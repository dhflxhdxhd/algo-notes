package baekjoon.gold.level3;

import java.io.*;
import java.util.*;

class MonkeyNode {
    int row;
    int col;
    int countK; // 말처럼 움직인 횟수 (K번 추적)
    int movements; // 동작 횟수

    public MonkeyNode(int row, int col, int countK, int movements) {
        this.row = row;
        this.col = col;
        this.countK = countK;
        this.movements = movements;
    }
}
// 1600. 말이 되고싶은 원숭이
public class Boj_1600 {

    static int k,w,h;
    static int[][] map;
    static boolean[][][] visited; // 방문 여부를 체크하는 3차원 배열 [행][열][말처럼 이동한 횟수 + 말처럼 이동하지 않았을 때(1)]
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        k = Integer.parseInt(br.readLine()); // 말처럼 움직일 수 있는 횟수
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); // 가로
        h = Integer.parseInt(st.nextToken()); // 세로

        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minMove = getMinMove();
        System.out.println(minMove);
    }

    // 말의 이동 경로(8)
    static int[] hdr = {-2,-2,-1,-1,1,1,2,2};
    static int[] hdc = {-1,1,-2,2,-2,2,-1,1};

    // 인접한 곳 이동 경로(상우하좌)
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    /**
     * 도착지에 도달하는 최소 이동 횟수를 구하는 메소드
     * @return 최소 이동 횟수, 도달할 수 없으면 -1
     */
    private static int getMinMove(){
        int minMove = -1;

        Queue<MonkeyNode> queue = new ArrayDeque<>();
        queue.offer(new MonkeyNode(0,0,0,0));
        visited[0][0][0] = true;

        // BFS 탐색 시작
        while(!queue.isEmpty()){
            MonkeyNode currentNode = queue.poll();
            int cr = currentNode.row;
            int cc = currentNode.col;
            int ck = currentNode.countK;
            int cm = currentNode.movements;

            // 도착지에 도달했다면
            if (cr == h-1 && cc == w-1){
                minMove = cm;
                return minMove;
            }

            for (int d = 0; d < 12; d++) {
                int nr;
                int nc;
                int nk;

                // 말처럼 이동할 수 없을 때는 상하좌우로만 이동
                if(ck >= k && d < 8){
                    continue;
                }

                // 말처럼 이동할 수 있을 때
                if(d < 8){
                    nr = cr + hdr[d];
                    nc = cc + hdc[d];
                    nk = ck+1;
                    // 이동할 좌표가 경계 안에 있다면
                    if(isInArea(nr, nc) && map[nr][nc] == 0){
                        // 방문한 적이 없다면
                        if(!visited[nr][nc][nk]){
                            visited[nr][nc][nk] = true;
                            queue.offer(new MonkeyNode(nr, nc, nk, cm+1));
                        }
                    }
                }else{ // 상하좌우로 이동할 때
                    nr = cr + dr[d-8];
                    nc = cc + dc[d-8];
                    nk = ck;
                    // 이동할 좌표가 경계 안에 있고 평지라면
                    if(isInArea(nr, nc) && map[nr][nc] == 0) {
                        // 방문한 적이 없다면
                        if(!visited[nr][nc][ck]) {
                            visited[nr][nc][ck] = true;
                            queue.offer(new MonkeyNode(nr, nc, nk, cm + 1));
                        }
                    }
                }
            }
        }
        return minMove;
    }

    /**
     * 주어진 좌표가 경계 안에 있는지 확인하는 메소드
     * @param row
     * @param col
     * @return true 경계 안 fals 경계 밖
     */
    private static boolean isInArea(int row, int col){
        return row>=0 && row<h && col>=0 && col<w;
    }
}
