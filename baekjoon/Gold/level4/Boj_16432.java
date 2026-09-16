package baekjoon.gold.level4;

import java.io.*;
import java.util.*;

// 16432. 떡장수와 호랑이
public class Boj_16432 {

    static ArrayList<Integer>[] riceCakes;
    static boolean[][] visited;
    static int[] result;
    static int n;
    static boolean check = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        riceCakes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            riceCakes[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                riceCakes[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visited = new boolean[n][10];
        result = new int[n];

        getOrders(0, 0);

        if(check){
            for(int num : result){
                System.out.println(num);
            }
        }else{
            System.out.println(-1);
        }
    }

    private static void getOrders(int day, int prev){
        if(check) return;

        if(day == n){
            check = true;
            return;
        }

        for(int riceCake : riceCakes[day]){ // 오늘 팔 떡 종류
            // 전날 판 떡이 아니고 && 방문하지 않은 떡이라면
            if(prev != riceCake && !visited[day][riceCake]){
                visited[day][riceCake] = true;
                result[day] = riceCake;
                getOrders(day+1, riceCake);
            }
        }
    }
}
