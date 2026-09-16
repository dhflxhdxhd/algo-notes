package baekjoon.gold.level5;

import java.io.*;
import java.util.*;
// 3649. 로봇 프로젝트
public class Boj_3649 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null && !input.isEmpty()){
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] holes = new int[n];
            for(int i=0; i<n; i++){
                holes[i] = Integer.parseInt(br.readLine());
            }

            if (n == 0) {
                sb.append("danger").append("\n");
                continue;
            }

            Arrays.sort(holes);

            int[] result = getPieces(holes, x);
            if(result[0] == -1 && result[1] ==-1){
                sb.append("danger").append("\n");
            }else{
                sb.append("yes").append(" ");
                sb.append(holes[result[0]]).append(" ").append(holes[result[1]]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
    private static int[] getPieces(int[] holes, int x){
        int[] result = new int[2];
        int left = 0;
        int right = holes.length-1;

        while(left < right){
            int sum = holes[left] + holes[right];

            if(sum == x){
                result[0] = left;
                result[1] = right;
                return result;
            }else if(sum > x){
                right--;
            }else{
                left++;
            }
        }

        return new int[] {-1, -1};
    }
}
