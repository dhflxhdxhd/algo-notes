package baekjoon.gold.level4;

import java.io.*;
import java.util.*;

// 9935. 문자열 폭발
public class Boj_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String removeStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        int originLen = origin.length();
        int removeLen = removeStr.length();

        int count = 0;
        while(count < originLen){
            char current = origin.charAt(count++);
            stack.push(current);

            // 현재 넣은 문자가 지울 문자열의 마지막과 같다면
            if( stack.size() >= removeLen && current == removeStr.charAt(removeLen-1)){
                boolean flag = true;
                for (int i = 0; i < removeLen; i++) {
                    if(stack.get(stack.size()-i-1) != removeStr.charAt(removeLen-i-1)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for (int i = 0; i < removeLen; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for (Character s : stack){
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
    }
}
