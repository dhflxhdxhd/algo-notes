package baekjoon.gold.level5;

import java.io.*;
import java.util.*;
// 2470. 두 용액
public class Boj_2470 {

    static int[] values;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        values = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        int[] result = getValues();

        StringBuilder sb = new StringBuilder();
        sb.append(values[result[0]]).append(" ");
        sb.append(values[result[1]]);
        System.out.println(sb.toString());
    }

    private static int[] getValues(){
        int left = 0;
        int right = values.length -1;
        int[] targetValue = new int[2];
        int sum = Integer.MAX_VALUE;

        while(left < right){
            int temp = values[left] + values[right];
            int absTemp = Math.abs(temp);

            if(temp == 0){
                targetValue[0] = left;
                targetValue[1] = right;
                return targetValue;
            }

            if(sum > absTemp){
                sum = absTemp;
                targetValue[0] = left;
                targetValue[1] = right;
            }

            if(temp > 0){
                right--;
            }else{
                left++;
            }
        }

        return targetValue;
    }
}
