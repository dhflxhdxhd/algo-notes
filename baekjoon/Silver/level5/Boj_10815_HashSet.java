package baekjoon.silver.level5;

import java.io.*;
import java.util.*;

// 10815. 숫자 카드
public class Boj_10815_HashSet {

    static int n,m;
    static int[]  cards, result;
    static HashSet<Integer> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        hashSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        cards = new int[m];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        hasCards();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    /**
     * 상근이가 카드를 가지고 있는지 확인하는 메소드
     */
    private static void hasCards(){
        for (int i = 0; i < m; i++) {
            result[i] = hashSet.contains(cards[i]) ? 1 : 0;
        }
    }
}
