package baekjoon.bronze.level2;

import java.io.*;

// 16916.부분 문자열
public class Boj_16916 {
    public static void main(String[] args) throws IOException {
        String s = null, p = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        p = br.readLine();

        int result = isSubstrOf(s, p);
        System.out.println(result);
    }

    /**
     * KMP 알고리즘 - s2가 s1의 부분 문자열인지 판별하는 함수
     * @param s1
     * @param s2
     * @return 부분 문자열임 1, 부분 문자열 아님 0
     */

    /**
     * 방법 1. s2가 s1의 부분 문자열인지 판별하는 함수 (단순 반복)
     * @param s1
     * @param s2
     * @return 부분 문자열임 1, 부분 문자열 아님 0
     */
    static int isSubstrOf(String s1, String s2) {
        int sSize = s1.length();
        int pSize = s2.length();

        if (pSize > sSize) {
            return 0;
        }

        for (int i = 0; i <= sSize - pSize; i++) {
            int j;
            for (j = 0; j < pSize; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            if (j == pSize) {
                return 1;
            }
        }

        return 0;
    }


}
