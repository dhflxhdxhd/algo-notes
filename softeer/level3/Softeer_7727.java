package softeer.level3;

import baekjoon.model.Coord;

import java.io.*;
import java.util.*;

// 7727. 함께하는 효도
public class Softeer_7727 {

    static int[][] map;
    static List<Coord> friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지도 크기
        int m = Integer.parseInt(st.nextToken()); // 친구 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        friends = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friends.add(new Coord(y,x));
        }
    }


    // 상우하좌
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    private static void getHarvest(){

    }
}
