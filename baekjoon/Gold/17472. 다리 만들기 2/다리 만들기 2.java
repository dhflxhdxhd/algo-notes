
import java.io.*;
import java.util.*;

class BridgeNode implements Comparable<BridgeNode> {
	int r;
	int c;
	int dist;

	public BridgeNode(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	public BridgeNode(int r, int c, int dist) {
		super();
		this.r = r;
		this.c = c;
		this.dist = dist;
	}

	// 거리에 대하여 오름차순 정렬
	@Override
	public int compareTo(BridgeNode o) {
		// TODO Auto-generated method stub
		return this.dist - o.dist;
	}
}

public class Main {

	static int n, m, num, minLen = 0;
	static boolean[] island;
	static int[][] map;
	static Queue<BridgeNode> queue = new LinkedList<BridgeNode>();
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로 크기 row
		m = Integer.parseInt(st.nextToken()); // 가로 크기 col

		map = new int[n][m];
		// 지도 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 구별하기
		num = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					checkIsland(i, j, num++);
				}
			}
		}
		
//		printMap();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 섬이 위치해 있다면
				if (map[i][j] >= 2) {
//					System.out.println("createBridge : " + i + " " + j);
					createBridge(i, j, map[i][j]);
				}
			}
		}

		kruskal();
		System.out.println(minLen);
	}

	static int[] parents;

	// 최소신장트리 비용을 계산하기 위해 크루스칼 알고리즘 사용
	static void kruskal() {
		minLen = 0;
		int check = 0;

		// 1. 간선들의 가중치 오름차순 정렬 -> 우선순위 큐를 사용해서 dist 값을 기준으로 정렬되어 있음
		// 2. 정렬된 간선 리스트에서 간선 순서대로 선택

		// 사이클 체크 : union-find를 사용하기 위한 배열 생성
		parents = new int[num];
		for (int i = 2; i < num; i++) {
			parents[i] = i;
		}

		int size = pq.size();
//		System.out.println("size : " + size);
		for (int i = 0; i < size; i++) {
			BridgeNode temp = pq.poll();

			if (find(temp.r) != find(temp.c)) {
				minLen += temp.dist;
				union(temp.r, temp.c);
				check++;
			}

			if (check == num - 3) {
				break;
			}
		}
		
		
//		System.out.println("check : " + check);

		// 선택된 다리가 섬의 개수(num-2)-1이 아니라면 모든 섬 연결 X
		if (check != (num - 3)) {
			minLen = -1;
		}
	}

	// union-find
	static int find(int a) {
		// 최상위 부모가 자기 자신이라면 자기 자신 반환
		if (parents[a] == a) {
			return a;
		}

		// 자기 자신이 최상위 노드가 아닌 경우 = 집합이 존재한다면
		// 재귀를 통해 최상위 노드 찾아냄 -> 집합 내의 모든 노드들의 부모 노드를 최상위 노드로 갱신
		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);

		// 부모 노드가 다르면 -> 부모 노드 연결
		if (ap != bp) {
			parents[ap] = bp;
		}
	}

	static PriorityQueue<BridgeNode> pq = new PriorityQueue<>(); // 크루스칼에서 다리 정렬을 따로 하지 않기 위함.
	// 해당 섬의 가장 자리에서 탐색 -> 다리 생성
	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	private static void createBridge(int r, int c, int now) {

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			int len = 0;
			// 경계 안에 있고 가장자리에 위치하면 -> 해당 방향으로 탐색 시작
			if (inArea(nr, nc) && map[nr][nc] == 0) {
//				System.out.println("d : " + d);
				for (int i = 1; i < Math.max(n, m); i++) {
					nr = r + dr[d] * i;
					nc = c + dc[d] * i;
//					System.out.println("nr : " + nr +  " nc : " + nc);

					if (inArea(nr, nc)) {
						// 바다라면 길이++
						if (map[nr][nc] == 0) {
							len++;

							// 바다는 아닌데 현재 섬 번호와 다르다면 연결
						} else if (map[nr][nc] != now) {
//							System.out.println("nr : " + nr +  " nc : " + nc);
							if (len >= 2) {
								pq.offer(new BridgeNode(now, map[nr][nc], len));
							}
							break;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}


	static void checkIsland(int r, int c, int cnt) {
		queue.clear();
		queue.offer(new BridgeNode(r, c));
		map[r][c] = cnt;
		
		while (!queue.isEmpty()) {
			BridgeNode temp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];

				if (inArea(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					queue.offer(new BridgeNode(nr, nc));
				}
			}
		}
	}

	static boolean inArea(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}


}
