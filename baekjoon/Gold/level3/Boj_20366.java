package baekjoon.gold.level3;

import java.io.*;
import java.util.*;

// 20366. 같이 눈사람 만들래?
public class Boj_20366 {

    static int minValue = Integer.MAX_VALUE;
    static int[] snowballs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        snowballs = new int[n];
        for (int i = 0; i < n; i++) {
            snowballs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snowballs);

        for(int i=0; i<n-1; i++){
            for (int j = i+1; j < n; j++) {
                getFamiliarDiff(i, j);
            }
        }

        System.out.println(minValue);
    }

    private static void getFamiliarDiff(int start, int end){
        int left = 0;
        int right = snowballs.length -1;
        int firstSnowman = snowballs[start] + snowballs[end];
        while (left < right){
            if(left == start || left == end) {
                left++;
                continue;
            }else if(right == end || right == start){
                right--;
                continue;
            }

            int secondSnowman = snowballs[left] + snowballs[right];
            minValue = Math.min(minValue, Math.abs(firstSnowman - secondSnowman));
            if(firstSnowman > secondSnowman){
                left++;
            }else{
                right--;
            }

            if(minValue == 0) break;
        }
    }
}
