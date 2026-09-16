package baekjoon.gold.level1;

import baekjoon.model.RouteNode;

import java.io.*;
import java.util.*;

// 18809. Gaaaaaaaaaarden
public class Boj_18809 {

    static int N,M, G, R, sAreasSize; // 행, 열, 초록 배양액 개수, 빨간 배양액 개수
    static int maxFlowers = 0;
    static int[][] map;
    static boolean[] gSelected;
    static boolean[] rSelected;

    static List<RouteNode> sprayableAreas = new ArrayList<>();

    static ArrayList<RouteNode> gSpray = new ArrayList<>();
    static ArrayList<RouteNode> rSpray = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 배양액을 뿌릴 수 있는 땅 모음
                if(map[i][j] == 2){
                    sprayableAreas.add(new RouteNode(i,j,1));
                }
            }
        }

        sAreasSize = sprayableAreas.size();
        gSelected = new boolean[sAreasSize];
        rSelected = new boolean[sAreasSize];

        getGreenSpray(0,0);
        System.out.println(maxFlowers);
    }

    /**
     * 조합을 이용하여 Green 배양액이 뿌려질 수 있는 장소 선택하는 메소드
     * @param start
     * @param count
     */
    private static void getGreenSpray(int start, int count){
        if(count == G){
            gSpray.clear();
            for (int i = 0; i < sAreasSize; i++) {
                if(gSelected[i]){
                    gSpray.add(sprayableAreas.get(i));
//                    System.out.println("green : " +  sprayableAreas.get(i).row + " " + sprayableAreas.get(i).col);
                }
            }

            getRedSpray(0,0);
            return;
        }

        for (int i = start; i < sAreasSize; i++) {
            if(!gSelected[i]){
                gSelected[i] = true;
                getGreenSpray(i+1, count+1);
                gSelected[i] = false;
            }
        }
    }

    /**
     * 조합을 이용하여 Green 배양액이 뿌려진 장소를 제외하고 Red 배양액이 뿌릴 수 있는 장소 선택하는 메소드
     * @param start
     * @param count
     */
    private static void getRedSpray(int start, int count) {
        if(count == R){
            rSpray.clear();
            for (int i = 0; i < sAreasSize; i++) {
                if(rSelected[i]){
                    rSpray.add(sprayableAreas.get(i));
//                    System.out.println("red : " +  sprayableAreas.get(i).row + " " + sprayableAreas.get(i).col);
                }
            }

            int flowers = getMaxFlowers();
//            System.out.println("flowers : " + flowers);
            maxFlowers = Math.max(maxFlowers, flowers);
            return;
        }

        for(int i=start; i<sAreasSize; i++){
            if(!gSelected[i] && !rSelected[i]){
                rSelected[i] = true;
                getRedSpray(i+1, count+1);
                rSelected[i] = false;
            }
        }
    }

    // 상우하좌
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static int getMaxFlowers(){
        Queue<RouteNode> gQueue = new ArrayDeque<>();
        Queue<RouteNode> rQueue = new ArrayDeque<>();
        int[][] copyMap = copyMap();
        int[][] gVisited = new int[N][M]; // green 방문체크
        int[][] rVisited = new int[N][M]; // red 방문 체크
        int flowers = 0;

        for (int i = 0; i < G; i++) {
            RouteNode temp = gSpray.get(i);
            gQueue.offer(temp);
            copyMap[temp.row][temp.col] = 3;
            gVisited[temp.row][temp.col] = 1;
        }

        for (int i = 0; i < R; i++) {
            RouteNode temp = rSpray.get(i);
            rQueue.offer(temp);
            copyMap[temp.row][temp.col] = 4;
            rVisited[temp.row][temp.col] = 1;
        }

        while(!gQueue.isEmpty() || !rQueue.isEmpty()){
            int gCount = gQueue.size();
            int rCount = rQueue.size();


            while(gCount-- > 0){
                RouteNode currentArea = gQueue.poll();
                int currentCount = currentArea.count;

                if(copyMap[currentArea.row][currentArea.col] == 5) continue;

                for (int d = 0; d < 4; d++) {
                    int nextR = currentArea.row + dr[d];
                    int nextC = currentArea.col + dc[d];

                    // 갈 수 있는 좌표이고 초록 배양액이 방문한 적 없다면
                    if(isInArea(nextR, nextC) && gVisited[nextR][nextC] == 0 ) {
                        // 호수가 아니고, 빨간 배양액이 방문한 적 없다면
                        if ( (copyMap[nextR][nextC] == 1 || copyMap[nextR][nextC] == 2)  && rVisited[nextR][nextC] == 0) {
                            gVisited[nextR][nextC] = currentCount + 1;
                            copyMap[nextR][nextC] = 3;
                            gQueue.offer(new RouteNode(nextR, nextC, currentCount+1));
                        }
                    }
                }
            }


            while(rCount-- > 0){
                RouteNode currentArea = rQueue.poll();
                int currentCount = currentArea.count;

                if(copyMap[currentArea.row][currentArea.col] == 5) continue;

                for (int d = 0; d < 4; d++) {
                    int nextR = currentArea.row + dr[d];
                    int nextC = currentArea.col + dc[d];

                    // 갈 수 있는 좌표이고 붉은 배양액이 방문한 적 없다면
                    if(isInArea(nextR, nextC) && rVisited[nextR][nextC] == 0){
                        // 초록 배양액이 방문한 곳이고, 같은 시점이라면
                        if (copyMap[nextR][nextC] == 3 && gVisited[nextR][nextC] == currentCount + 1) {
                            copyMap[nextR][nextC] = 5;
                            flowers++;
                        // 호수가 아니라면
                        } else if ((copyMap[nextR][nextC] == 1 || copyMap[nextR][nextC] == 2)) {
                            rVisited[nextR][nextC] = currentCount + 1;
                            copyMap[nextR][nextC] = 4;
                            rQueue.offer(new RouteNode(nextR, nextC, currentCount + 1));
                        }
                    }
                }
            }

        }

        return flowers;
    }

    static boolean isInArea(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    static int[][] copyMap(){
        int[][] tempMap = new int[N][M];

        for(int i=0; i<N; i++){
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        return tempMap;
    }
}
