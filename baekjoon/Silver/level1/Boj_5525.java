package baekjoon.silver.level1;

import java.io.*;
import java.util.*;

public class Boj_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int patternSize = n + n +1;
        int m = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length()-patternSize; i++) {
            if(str.charAt(i) == 'I'){
                boolean result = checkIOI(str.substring(i, i+patternSize), patternSize);
                if (result) count++;
            }
        }

        System.out.println(count);
    }


    private static boolean checkIOI(String str,  int patternSize ){
        for(int i=0; i<patternSize; i++){
            if(i%2 == 0){
                if(str.charAt(i) != 'I'){
                    return false;
                }
            }else{
                if(str.charAt(i) != 'O'){
                    return false;
                }
            }
        }
        return true;
    }
}
