import java.io.*;
import java.util.*;

/* 
 * 16948. 데스나이트
 * 
*/

class chessNode{
	int r;
	int c;
	int count; // 이동 횟수
	public chessNode(int r, int c, int count) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
	}
}

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int r2,c2,n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 체스판의 크기
		
		map = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		System.out.println(moveTo(r1,c1));
	}
	
	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static int moveTo(int startR, int startC) {
		Queue<chessNode> queue = new LinkedList<>();
		queue.offer(new chessNode(startR, startC, 0));
		visited[startR][startC] = true;
		
		while (!queue.isEmpty()) {
			chessNode temp = queue.poll();
			
			if(temp.r == r2 && temp.c == c2) {
				return temp.count;
			}
			
			for (int d = 0; d < dc.length; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				
				if(inArea(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new chessNode(nr, nc, temp.count+1));
				}
			}
		}
		
		return -1;
	}
	
	static boolean inArea(int row, int col) {
		return row >= 0  && row < n && col >= 0 && col < n;
	}
}
