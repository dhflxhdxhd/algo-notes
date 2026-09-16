package baekjoon.silver.level1;

import baekjoon.model.Coord;

import java.io.*;
import java.util.*;

// 2667. 단지번호 붙이기
public class Boj_2667_BFS {

    static int n; // 지도의 크기
    static int[][] map; // 지도를 저장할 2차원 배열
    static List<Integer> houses = new LinkedList<>(); // 각 단지의 집 수를 저장할 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int number = 2; // 단지번호
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    findTown(i,j, number++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number-2);
        sb.append("\n");

        Collections.sort(houses); // 단지 집 수 오름차순 정렬
        for (int h = 0; h < houses.size(); h++) {
            sb.append(houses.get(h));
            sb.append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }

    // 상우하좌 방향으로 이동하기 위한 배열
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    /**
     * BFS를 사용하여 단지를 탐색하는 메서드
     * @param y 현재 세로 좌표
     * @param x 현재 가로 좌표
     * @param number 단지번호 (2부터 시작)
     */
    private static void findTown(int y, int x, int number){
//        Queue<Coord> queue = new LinkedList<>();
        Queue<Coord> queue = new ArrayDeque<Coord>();
        queue.offer(new Coord(y,x));
        map[y][x] = number;
        int count = 1; // 현재 단지에 속하는 집의 수

        while (!queue.isEmpty()){
            Coord coord = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = coord.x + dx[i];
                int ny = coord.y + dy[i];

                if(isInArea(nx,ny)  && map[ny][nx] == 1){
                    map[ny][nx] = number;
                    count++;
                    queue.offer(new Coord(ny, nx));
                }
            }
        }

        houses.add(count);
    }

    /**
     * 주어진 좌표가  지도 내에 있는지 확인하는 메서드
     * @param x 가로 좌표
     * @param y 세로 좌표
     * @return 주어진 좌표가  지도 내에 있는지 확인하는 메서드
     */
    private static boolean isInArea(int x, int y){
        return x >= 0 &&  x < n && y >= 0 && y < n;
    }
}