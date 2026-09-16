package baekjoon.silver.level2;

import java.io.*;
import java.util.*;

// 1654. 랜선 자르기
public class Boj_1654 {

    static int[] lines;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);
        long result = getMaxLength(lines[k-1], n);
        System.out.println(result);
    }

    private static long getMaxLength(int rightLength, int need){
        long left = 1;
        long right = rightLength;

        while (left <= right){
            long mid = left + (right - left)/2;
            int count = countLines(mid);

            if(count < need){
                right = mid-1;
            }else if(count >= need){
                left = mid+1;
            }
        }
        return right;
    }

    private static int countLines(long currentLength){
        int count = 0;
        for(int line : lines){
            count += line / currentLength;
        }
        return count;
    }
}
