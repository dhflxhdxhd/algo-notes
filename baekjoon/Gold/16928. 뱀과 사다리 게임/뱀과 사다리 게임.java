import java.io.*;
import java.util.*;

// 16928. 뱀과 사다리 게임

// 사다리 위치 정보
class Ladder {
	int x;
	int y;
	public Ladder(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Snake {
	int u;
	int v;
	public Snake(int u, int v) {
		super();
		this.u = u;
		this.v = v;
	}
}
public class Main {
	
	static int board[], n,m;
	static boolean[] visited = new boolean[101];
	static List<Ladder> ladder;
	static List<Snake> snake;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 사다리 수
		m = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		board = new int[101];
		visited = new boolean[101];
		
		ladder = new ArrayList<Ladder>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ladder.add(new Ladder(x, y));
		}
		
		snake = new ArrayList<Snake>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			snake.add(new Snake(u, v));
		}
		
		moveTo(1);
	}
	
	static void moveTo(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{start,0});
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int[] t = queue.poll();
			int num = t[0];
			int count = t[1];
			
			if(num == 100) {
				System.out.println(count);
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				int temp = num + i;
				if(inArea(temp) && !visited[temp]) {
					int tempto = checkLadder(temp);
					if(tempto > 0) {
						visited[temp] = true;
						visited[tempto] = true;
						queue.offer(new int[] {tempto, count+1});
						continue;
					}
					
					int temptos = checkSnake(temp);
					if(temptos > 0) {
						visited[temp] = true;
						visited[temptos] = true;
						queue.offer(new int[] {temptos, count+1});
						continue;
					}
					
					visited[temp] = true;
					queue.offer(new int[] {temp, count+1});
				}
			}
		}
	}
	
	static int checkLadder(int num) {
		for (int i = 0; i < n; i++) {
			if(ladder.get(i).x == num) {
				return ladder.get(i).y;
			}
		}
		
		return 0;
	}

	static int checkSnake(int num) {
		for (int i = 0; i < m; i++) {
			if(snake.get(i).u == num) {
				return snake.get(i).v;
			}
		}
		
		return 0;
	}
	
	static boolean inArea(int num) {
		return num > 0 && num <= 100 ; 
	}
}
