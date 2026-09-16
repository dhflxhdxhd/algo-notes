package softeer.level3;

import java.io.*;
import java.util.*;

// 7369. 나무 수확
public class Softeer_7369 {
    static int n,maxHarvest = 0; // 최대 수확량
    static int[][] map;
    static int[][][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine()); // 격자 크기 n X n
        map = new int[n][n];
        memo = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getMaxHarvest(0,0);

        maxHarvest = memo[n-1][n-1][1];
        System.out.println(maxHarvest);
    }

    private static void getMaxHarvest(int x, int y){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 스프링쿨러 사용하지 않았을 때
                int up = (i>0) ? memo[i-1][j][0] : 0;
                int left = (j>0) ? memo[i][j-1][0] : 0;
                memo[i][j][0] = Math.max(up, left) + map[i][j];

                // 스프링쿨러 사용할 때
                int upMax = (i>0) ? Math.max(memo[i-1][j][1] + map[i][j] , memo[i-1][j][0] + map[i][j] * 2) : map[i][j]*2;
                int leftMax = (j>0) ? Math.max(memo[i][j-1][1] + map[i][j], memo[i][j-1][0] + map[i][j] * 2) : map[i][j]*2;
                memo[i][j][1] = Math.max(upMax, leftMax);
            }
        }
    }

//
//    private static void getMaxHarvest(int x, int y, int currentSum, boolean[][] visited){
//        currentSum += map[x][y];
//        visited[x][y] = true; // 방문처리
//
//        // 마지막까지 도달했으면
//        if(x == n-1 && y == n-1){
//            int sprinkler = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if(visited[i][j]){
//                        sprinkler = Math.max(sprinkler, map[i][j]);
//                    }
//                }
//            }
//            maxHarvest = Math.max(maxHarvest, currentSum + sprinkler);
//        }
//
//        if(y+1 < n){
//            getMaxHarvest(x, y+1, currentSum, visited);
//        }
//
//        if(x+1 < n){
//            getMaxHarvest(x+1, y, currentSum, visited);
//        }
//
//        visited[x][y] = false;
//    }
}
