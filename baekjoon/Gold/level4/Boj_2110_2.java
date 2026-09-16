package baekjoon.gold.level4;

import java.io.*;
import java.util.*;

// 2110. 공유기 설치
public class Boj_2110_2 {

    static int n,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 집 개수
        c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        int result = getMinDistance(houses);
        System.out.println(result);
    }


    private static int getMinDistance(int[] houses){
        int left = 1;
        int right = houses[n-1] - houses[0];

        while(left <= right){
            int mid = left + (right - left)/2;

            int tempRouters = countRouters(houses, mid);
            if(tempRouters < c){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return left-1;
    }


    private static int countRouters(int[] houses, int dist){
        int count = 1;
        int currentHouse = houses[0];

        for (int i = 1; i < n; i++) {
            int tempHouse = houses[i];

            if(tempHouse - currentHouse >= dist){
                count++;
                currentHouse = tempHouse;
            }
        }

        return count;
    }
}
