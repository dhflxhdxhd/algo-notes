import java.io.*;
import java.util.*;

// 2146. 다리 만들기

class NodeD{
	int r;
	int c;
	int dist;
	
	public NodeD(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	public NodeD(int r, int c, int dist) {
		super();
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
}


public class Main {
	
	static boolean[][] visited;
	static int n, map[][],minDist ;
	static Queue<NodeD> queue = new LinkedList<NodeD>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine()); // 지도의 크기
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					makeIsland(i, j, num++);
				}
			}
		}
		
		minDist = Integer.MAX_VALUE;
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] >= 2) {
					getBridge(i,j, map[i][j]);
				}
			}
		}
		
		System.out.println(minDist);
	}

	
	// 상우하좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static void getBridge(int r, int c, int num) {
		visited = new boolean[n][n];
		queue.clear();
		queue.offer(new NodeD(r, c,0));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			NodeD temp = queue.poll();
			
			if(minDist < temp.dist) {
				continue;
			}
			
			
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(inArea(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;

					// 바다이면 다리 길이++;
					if(map[nr][nc] == 0) {
						queue.offer(new NodeD(nr, nc, temp.dist+1));

					// 처음 시작한 섬과 다른 섬이라면 다리 연결 O
					// 가장 먼저 도달했을 때가 제일 짧은 길이
					}else if(map[nr][nc] != num ) {
						minDist = Math.min(temp.dist, minDist);
					}
				}
			}
		}
	}

	static void makeIsland(int r, int c, int num) {
		queue.clear();
		queue.offer(new NodeD(r, c));
		
		while (!queue.isEmpty()) {
			NodeD temp = queue.poll();
			map[temp.r][temp.c] = num;
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(inArea(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = num;
					queue.offer(new NodeD(nr, nc));
				}
			}
		}
	}
	
	static boolean inArea(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
}
