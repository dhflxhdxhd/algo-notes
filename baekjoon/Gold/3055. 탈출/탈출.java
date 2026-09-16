import java.io.*;
import java.util.*;


/*
탈출 
---------------
. 비어있는 곳
* 물이 차있는 지역
X 돌
D 비버의 굴
S 고슴도치의 위치
 */

class Nodes {
	int r;
	int c;
	int t;
	
	
	public Nodes(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}



	public Nodes(int r, int c, int t) {
		super();
		this.r = r;
		this.c = c;
		this.t = t;
	}
}

public class Main {
	
	private static char[][] map;
	private static int r,c;
	static Nodes beaver = null, hedgehog = null;
	private static Queue<Nodes> water; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		// map 초기 생성
		map = new char[r][c];
		water = new LinkedList<Nodes>(); // 물의 위치를 담고 있는 메소드
 		
		for (int row = 0; row < r; row++) {
			String str = br.readLine();
			for (int col = 0; col < c; col++) {
				map[row][col] = str.charAt(col);
				
				if(map[row][col] == '*') {
					water.add(new Nodes(row, col));
				}else if(map[row][col] == 'S') {
					hedgehog = new Nodes(row, col, 0);
				}
				
			}
		}
 		
		moveTo(hedgehog.r, hedgehog.c);
	}
	
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static void moveTo(int startR, int startC) {
		
		Queue<Nodes> queue = new LinkedList<Nodes>(); // 고슴도치가 이동하는 위치
		queue.add(new Nodes(startR, startC, 0));
		
		while (!queue.isEmpty()) {
			
			// 물 퍼뜨림.
			int size1 = water.size();
			for (int i = 0; i < size1; i++) {
				Nodes wtemp = water.poll();
						
				for (int d = 0; d < 4; d++) {
					int nr = wtemp.r + dr[d];
					int nc = wtemp.c + dc[d];
					
					// 경계 안에 있고 && 빈 칸이라면 -> 퍼뜨리기
					if(inArea(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.add(new Nodes(nr, nc));
					}
				}
			}
		
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Nodes temp = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					
					// 이동할 위치가 경계 안에 있고
					if(inArea(nr, nc) ) {
						// 빈 공간 이라면
						if(map[nr][nc] == '.') {
							// 이동 표시 해주고 큐에 넣기
							map[nr][nc] = '!';
							queue.offer(new Nodes(nr, nc, temp.t+1));
						// 비버 굴이라면
						}else if(map[nr][nc] == 'D') {
							// 시간+1 출력 + 끝
							System.out.println(temp.t+1);
							return;
						}
					}
				}	
			}
		}
		
		System.out.println("KAKTUS");
	}
	
	
	/**
	 * 해당 좌표가 경계 안에 있는지 확인하는 메소드
	 */
	static boolean inArea(int row, int col) {
		return row >= 0 && row < r && col >= 0 && col < c;
	}
	
}
