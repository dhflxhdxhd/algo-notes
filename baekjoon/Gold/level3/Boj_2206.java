package baekjoon.gold.level3;

import baekjoon.model.BoardNode;
import baekjoon.model.RouteNode;

import java.io.*;
import java.util.*;

// 2206. 벽 부수고 이동하기
public class Boj_2206 {

    static int[][] map;
    static boolean[][] visited;
    static int minRoute = Integer.MAX_VALUE;
    static List<BoardNode> walls;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // (0,0) ~ (n-1, m-1)
        visited = new boolean[n][m];
        walls = new LinkedList();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';

                if(map[i][j] == 1){
                    walls.add(new BoardNode(i,j));
                }
            }
        }

        for(BoardNode wall : walls){
            map[wall.row][wall.col] = 0;
            visited = new boolean[n][m];
            getMinRoute();
            map[wall.row][wall.col] = 1;
        }

        int result = minRoute == Integer.MAX_VALUE ? -1 : minRoute;
        System.out.println(result);
    }

    // 상우하좌
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static void getMinRoute(){
        Queue<RouteNode> queue = new ArrayDeque<>();
        queue.offer(new RouteNode(0,0, 1));

        while(!queue.isEmpty()){
            RouteNode currentNode = queue.poll();
            int currentRow = currentNode.row;
            int currentCol = currentNode.col;
            int currentCount = currentNode.count;
            visited[currentRow][currentCol] = true;

            if(currentRow == n-1 && currentCol == m-1){
                minRoute = Math.min(minRoute, currentCount);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = currentRow + dr[d];
                int nc = currentCol + dc[d];

                if(isInArea(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]){
                    queue.offer(new RouteNode(nr,nc,currentCount+1));
                    visited[nr][nc] = true;
                }
            }
        }

    }

    private static boolean isInArea(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
