package baekjoon.silver.level4;

import java.io.*;
import java.util.*;
// 1620. 나는야 포켓몬 마스터 이다솜
public class Boj_1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int m = Integer.parseInt(st.nextToken()); // 맞춰야 할 문제 수

        HashMap<Integer, String> dic = new HashMap<>();
        HashMap<String, Integer> dic2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            dic.put(i, name);
            dic2.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            if(isNumber(target)){
                String value = dic.get(Integer.parseInt(target));
                sb.append(value).append("\n");
            }else{
                Integer value = dic2.get(target);
                sb.append(value).append("\n");
            }
        }

        System.out.println(sb.deleteCharAt(sb.length()-1).toString());
    }

    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
