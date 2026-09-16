import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 식탁의 길이
        int k = Integer.parseInt(st.nextToken()); // 단위 거리
        int count = 0; // 햄버거를 먹은 사람 수
        char[] table = br.readLine().toCharArray();

        for (int t = 0; t < table.length; t++) {
            // 사람이 있는 위치에서
            if (table[t] == 'P') {
                // 왼쪽 체크
                boolean ateBurger = false;
                for (int i = Math.max(0, t - k); i < t; i++) {
                    if (table[i] == 'H') {
                        count++;
                        table[i] = 'F'; // 햄버거를 먹었음을 표시
                        ateBurger = true;
                        break;
                    }
                }

                // 오른쪽 체크 (왼쪽에서 햄버거를 못 먹었을 경우)
                if (!ateBurger) {
                    for (int i = t + 1; i <= Math.min(n - 1, t + k); i++) {
                        if (table[i] == 'H') {
                            count++;
                            table[i] = 'F'; // 햄버거를 먹었음을 표시
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}