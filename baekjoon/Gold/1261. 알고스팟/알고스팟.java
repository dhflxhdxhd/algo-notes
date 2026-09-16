import java.io.*;
import java.util.*;

/**
 * 1216. 알고스팟
 * 벽 : 이동 X 
 * 이동 방향 : 상우하좌
 * 무기
 * 1) AOJ : 벽 부실 수 있음
 * 2) sudo : 벽을 한 번에 다 없앨 수 있음. (여기선 X)
 * 
 * ? (1,1) to (n,m) : 벽을 최소 몇 개 부서야할까? 
 * (0,0) -> (n-1, m-1)
 */

class SpotNode {
	int r;
	int c;
	int walls;
	
	public SpotNode(int r, int c, int walls) {
		super();
		this.r = r;
		this.c = c;
		this.walls = walls;
	}
}
public class Main {
	
	static int c,r;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken()); // 가로
		r = Integer.parseInt(st.nextToken()); // 세로
		
		// 0 빈 방 1 벽
		map = new int[r][c];
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		moveTo(0, 0);
	}
	
	// 상우하좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static void moveTo(int startR, int startC) {
//		Queue<SpotNode> queue = 
		Deque<SpotNode> queue = new ArrayDeque<SpotNode>();
		
		queue.offer(new SpotNode(0, 0, 0));
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			SpotNode temp = queue.poll();
			
			if(temp.r == r-1 && temp.c == c-1) {
				System.out.println(temp.walls);
				return;
			}
			
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(inArea(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(map[nr][nc] == 1) {
						queue.offer(new SpotNode(nr, nc, temp.walls+1));
					}else {
						queue.offerFirst(new SpotNode(nr, nc, temp.walls));
					}
				}
			}
		}
	}

	static boolean inArea(int row, int col) {
		return row >= 0 && row < r && col>= 0 && col < c;
	}
}
