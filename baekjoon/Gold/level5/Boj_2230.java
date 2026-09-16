package baekjoon.gold.level5;

import java.io.*;
import java.util.*;
public class Boj_2230 {

    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int result = findMinDifference(m);
        System.out.println(result);
    }

    /**
     * 그 차이가 m 이상이면서 제일 작은 경우
     * @param m
     * @return
     */
    private static int findMinDifference(int m){
        int left = 0;
        int right = 1;
        int result = arr[arr.length-1] -arr[0];
        while(right < arr.length){
            int sum = arr[right] -arr[left];
            if(sum >= m){
                result = Math.min(sum, result);
                left++;
            }else if(sum < m){
                right++;
            }

            if(left == right){
                right++;
            }
        }
        return result;
    }
}
