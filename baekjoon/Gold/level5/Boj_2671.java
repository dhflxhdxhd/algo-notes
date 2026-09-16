package baekjoon.gold.level5;

import java.io.*;
import java.util.regex.Pattern;

// 2671. 잠수함 식별
public class Boj_2671 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        String result = checkTarget(target) ? "SUBMARINE" : "NOISE";
        System.out.println(result);
    }

    private static boolean checkTarget(String target){
        String pattern = "^(100+1+|01)+$";

        return Pattern.matches(pattern, target);
    }
}
