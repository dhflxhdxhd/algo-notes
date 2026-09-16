package baekjoon.gold.level4;

import java.io.*;
import java.util.*;
// 1806. 부분합
public class Boj_1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMinDistance(numbers, s));
    }

    private static int getMinDistance(int[] numbers, int standardNum){
        int left = 0;
        int right = 0;

        int len = numbers.length;
        int sum = 0;
        int minLength = len + 1;

        while(right < len){
            sum += numbers[right];

            while(sum >= standardNum){
                minLength = Math.min(minLength, right - left + 1);
                sum -= numbers[left];
                left++;
            }

            right++;
        }

        if(minLength == len+1){
            return 0;
        }else{
            return minLength;
        }
    }
}
