package baekjoon.gold.level5;

import java.io.*;
import java.util.*;

// 1759. 암호 만들기
public class Boj_1759 {

    static char[] alpha;
    static int l,c; // 문자의 길이, 문자 종류의 개수
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alpha = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha); // 알파벳 정렬
        makePassword(0, 0,0,0,"");
        System.out.println(sb.deleteCharAt(sb.length()-1).toString());
    }

    /**
     * 가능한 암호 조합을 만드는 메소드
     * 이 메소드는 주어진 알파벳 배열에서 특정 조건을 만족하는 암호 조합을 재귀적으로 생성합니다.
     * @param index 현재 탐색 중인 알파벳 배열의 인덱스
     * @param vowels 현재 선택된 모음의 개수
     * @param consonants 현재 선택된 자음의 개수
     * @param length 현재 조합의 길이
     * @param str 현재까지 선택된 알파벳으로 구성된 문자열
     */
    private static void makePassword(int index, int vowels,int consonants, int length, String str ){
        // 조합의 길이가 l과 같으면
        if(length == l){
            // 최소 1개의 모음과 2개의 자음이 포함되어 있으면
            if(vowels >= 1 && consonants >= 2){
                sb.append(str).append("\n");
            }
            return;
        }

        // 남은 알파벳(index)을 탐색하며 조합 생성
        for (int i = index; i < c; i++) {
            // 현재 알파벳이 모음인 경우
            if(alpha[i] == 'a' ||alpha[i] == 'e'||alpha[i] == 'i'||alpha[i] == 'o'||alpha[i] == 'u' ){
                makePassword(i+1, vowels+1, consonants,length+1, str+alpha[i]);
            }else{
                // 자음인 경우
                makePassword(i+1, vowels,consonants+1, length+1, str+alpha[i]);
            }
        }
    }
}
