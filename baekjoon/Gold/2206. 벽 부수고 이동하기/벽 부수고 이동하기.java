import java.io.*;
import java.util.*;

class MinRouteNodes {
    int row;
    int col;
    int dist; // 이동 거리
    boolean isBroke; // 벽이 부셔진 여부

    public MinRouteNodes(int row, int col, int dist, boolean isBroke) {
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.isBroke = isBroke;
    }
}

// 2206. 벽 부수고 이동하기
public class Main {

    static int[][] map;
    static boolean[][][] visited;
    static boolean wallExists = false;
    static int minRoute = Integer.MAX_VALUE;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // (0,0) ~ (n-1, m-1)
        visited = new boolean[2][n][m];  // 0 : 벽을 부셨음. 1 : 벽 안부셨음.
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        getMinRoute();
        minRoute = minRoute == Integer.MAX_VALUE ? -1 : minRoute;
        System.out.println(minRoute);
    }

    // 상우하좌
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static void getMinRoute(){
        Queue<MinRouteNodes> queue = new ArrayDeque<>();
        queue.offer(new MinRouteNodes(0,0,1, false));
        visited[0][0][0] = true; // 초기 방문처리

        while(!queue.isEmpty()){
            MinRouteNodes currentNode = queue.poll();
            int currentRow = currentNode.row;
            int currentCol = currentNode.col;
            int currentDist = currentNode.dist;
            boolean isBrokenNow = currentNode.isBroke;

            if(currentRow == n-1 && currentCol == m-1){
                minRoute = currentDist;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = currentRow + dr[d];
                int nc = currentCol + dc[d];

                if(!isInArea(nr, nc)) continue;

                // 벽이 아니라면
                if(map[nr][nc] == 0){
                    // 벽을 부신 적이 없다면
                    if(!isBrokenNow){
                        // 방문한 적이 없다면
                        if(!visited[0][nr][nc]){
                            visited[0][nr][nc] = true;
                            queue.offer(new MinRouteNodes(nr, nc, currentDist+1, false));
                        }
                    }else{ // 벽을 부신 적이 있다면
                        // 방문한 적이 없다면
                        if(!visited[1][nr][nc]){
                            visited[1][nr][nc] = true;
                            queue.offer(new MinRouteNodes(nr, nc, currentDist+1, true));
                        }
                    }

                }else{ // 벽이라면
                    // 벽을 부순 적이 없다면
                    if(!isBrokenNow){
                        if(!visited[1][nr][nc]){
                            visited[1][nr][nc] = true;
                            queue.offer(new MinRouteNodes(nr, nc, currentDist+1, true));
                        }
                    }
                }
            }
        }
    }

    private static boolean isInArea(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}