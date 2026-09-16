package baekjoon.bronze.level5;

import java.io.*;
import java.util.*;
// 9086. 문자열
public class Boj_9086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String target = br.readLine();

//            String result = "";
//            result += target.substring(0,1);
//            result += target.substring(target.length()-1);

//            String result = target.charAt(0) + "" + target.charAt(target.length()-1);
            String result = String.valueOf(target.charAt(0)) + String.valueOf(target.charAt(target.length()-1));
            sb.append(result).append("\n");

        }

        System.out.println(sb.deleteCharAt(sb.length()-1).toString());
    }
}
