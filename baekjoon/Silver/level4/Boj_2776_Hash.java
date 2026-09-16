package baekjoon.silver.level4;

import java.io.*;
import java.util.*;

// 2776. 암기왕
public class Boj_2776_Hash {
    static int n1, n2 = 0; // 각각 수첩 1, 2에 들어있는 정수 수
    static int[] note2; // 수첩1, 수첩2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            int n1 = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> note1 = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int number;
            for (int i = 0; i < n1; i++) {
                number = Integer.parseInt(st.nextToken());
                note1.put(number, note1.getOrDefault(number, 0) +1);
            }

            int n2 = Integer.parseInt(br.readLine());
            note2 = new int[n2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(hasNumberInNote1(note1));
        }
    }

    private static String hasNumberInNote1(HashMap<Integer, Integer> note){
        StringBuilder sb = new StringBuilder();

        for(int number : note2){
            if(note.get(number) == null){
                sb.append(0).append("\n");
            }else{
                sb.append(1).append("\n");
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
