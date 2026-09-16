package basic.patternmatching;

import java.io.*;
import java.util.*;

/*
String Matching 문자열 비교
KMP 알고리즘
1) 부분 일치 테이블 생성
2) 텍스트에서 패턴 검색
 */
public class KMPAlgorithm {

    /**
     * 부분 일치 테이블을 생성하는 메소드
     * @param pattern 비교할 문자열
     * @return 부분 일치 테이블
     */
    private static int[] makeLPSArray(String pattern){
        int length = 0; // 각 위치까지의 패턴에서 접두사와 접미사가 일치하는 최대 길이
        int i = 1; // 패턴에서 현재 검사 중인 위치 (Index)
        int pLength = pattern.length();
        int[] lps = new int[pLength];

        lps[0] = 0; // 첫 번째 문자는 항상 0

        while (i < pLength){
            if(pattern.charAt(length) ==  pattern.charAt(i)){
                length++;
                lps[i] = length;
                i++;
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }


    /**
     * 텍스트에서 패턴 검색
     * @param text
     * @param pattern
     */
    public static void KMPSearch(String text, String pattern){
        int tLength = text.length();
        int plength = pattern.length();

        if(tLength < plength){
            System.out.println("text의 길이가 비교할 문자열의 길이보다 짧습니다.");
            return;
        }

        // LPS 배열 생성
        int[] lps = makeLPSArray(pattern);

        // 각 인덱스 초기화
        int tIdx = 0; // 텍스트에서 현재 비교 중인 인덱스
        int pIdx = 0; // 패턴에서 현재 비교 중인 인덱스

        // 1. 텍스트 끝까지 탐색
        while (tIdx < tLength){
            if(text.charAt(tIdx) == pattern.charAt(pIdx)){ // 문자가 같으면 인덱스를 증가시켜 다음 문자로 이동
                tIdx++;
                pIdx++;
            }


            if(pIdx == plength){  // 패턴 발견
                System.out.println("패턴이 텍스트의 인덱스 " + (tIdx - pIdx) + "에서 발견되었습니다.");
                pIdx = lps[pIdx-1];
            } else if (tIdx < tLength && text.charAt(tIdx) != pattern.charAt(pIdx) ) { // 현재 문자들이 일치하지 않을 때

                // 이전에 비교하고 있는 인덱스가 있다면
                if(pIdx != 0){
                    pIdx = lps[pIdx-1];
                } else{
                    tIdx++;
                }
            }
        }

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        String pattern = st.nextToken();

        System.out.println("문자열 비교를 시작하겠습니다.");
        KMPSearch(text, pattern);
    }
}
