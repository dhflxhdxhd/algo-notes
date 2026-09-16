package baekjoon.bronze.level2;

import java.io.*;

public class Boj_16916_KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String pattern = br.readLine();

        patternSearchKMP(text,pattern);
    }

    private static void patternSearchKMP(String text, String pattern){
        int tLength = text.length();
        int pLength = pattern.length();

        if(tLength < pLength){
            System.out.println("0");
            return;
        }

        int tIdx = 0;
        int pIdx = 0;

        int[] lps = makeLPS(pattern);

        while(tIdx < tLength){
            if(text.charAt(tIdx) == pattern.charAt(pIdx)){
                tIdx++;
                pIdx++;
            }

            // 패턴 발견
            if(pIdx == pLength){
                System.out.println("1");
                return;
            } else if(tIdx < tLength && text.charAt(tIdx) != pattern.charAt(pIdx)){
                if(pIdx != 0){
                    pIdx = lps[pIdx-1];
                }else{
                    tIdx++;
                }
            }
        }

        System.out.println("0");
        return;
    }

    private static int[] makeLPS(String pattern){
        int pLength = pattern.length();
        int[] lps = new int[pLength];

        int length = 0;
        int i = 1;

        lps[0] = 0;

        while(i < pLength){
            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
