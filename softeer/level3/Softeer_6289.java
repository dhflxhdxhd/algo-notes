package softeer.level3;

import java.io.*;
import java.util.*;

// 6289. 우물 안 개구리
public class Softeer_6289 {

    static int n,m,count = 0;
    static int[] weights;
    static List<ArrayList<Integer>> relations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 회원 수
        m = Integer.parseInt(st.nextToken()); // 친분 관계 수

        st = new StringTokenizer(br.readLine());
        weights = new int[n+1]; // 각 회원이 들 수 있는 역기의 무게
        for (int w = 1; w < n+1; w++) {
            weights[w] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n+1; i++) {
           relations.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        // 자신이 최고인지 체크 (1~n)
        for (int idx = 1; idx < n+1; idx++) {
            boolean check = amITheBest(idx, relations.get(idx));
            if(check){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean amITheBest(int idx, ArrayList<Integer> relation){
        boolean check = true;
        int length = relation.size();
        int myWeight = weights[idx];

        // 누구와도 친분이 없을 경우
        if(length == 0){
            return check;
        }

        for (int r = 0; r < length; r++) {
            if(weights[relation.get(r)] >= myWeight){
                check = false;
                return check;
            }
        }

        return check;
    }
}
