package baekjoon.silver.level4;

import java.io.*;
import java.util.*;

// 2776. 암기왕
public class Boj_2776 {

    static int n1, n2 = 0; // 각각 수첩 1, 2에 들어있는 정수 수
    static int[] note1, note2; // 수첩1, 수첩2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test<T; test++){
            n1 = Integer.parseInt(br.readLine());
            note1 = new int[n1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n1; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            n2 = Integer.parseInt(br.readLine());
            note2 = new int[n2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);
            System.out.println(hasNumberInNote1());
        }
    }

    private static String hasNumberInNote1(){
        StringBuilder sb = new StringBuilder();

        for(int number : note2){
            int result = findNumber(number);
            sb.append(result).append("\n");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }


    private static int findNumber(int target){
        int left = 0;
        int right = n1-1;

        while (left <= right){
            int mid = left + (right - left) /2;

            if(note1[mid] == target){
                return 1;
            }else if(note1[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}
