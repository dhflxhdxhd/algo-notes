package baekjoon.gold.level4;

import java.io.*;
import java.util.*;

// 22945. 팀 빌딩
public class Boj_22945 {

    static int n;
    static int[] developers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        developers = new int[n];
        for (int i = 0; i < n; i++) {
            developers[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = getMaxValue();
        System.out.println(maxValue);
    }

    private static int getMaxValue(){
        int left = 0;
        int right = n-1;
        int mid = right - left -1;
        int maxValue = Integer.MIN_VALUE;
        while(left < right ){
            int value = mid * Math.min(developers[left], developers[right]);

            if(developers[left] >= developers[right]){
                right--;
            }else if(developers[left] < developers[right]){
                left++;
            }
            maxValue = Math.max(maxValue, value);
            mid--;
        }

        return maxValue;
    }
}
