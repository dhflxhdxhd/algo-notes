import java.io.*;
import java.util.*;

public class Main {

    static int n, m, l;
    static int[] places;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
        m = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 개수
        l = Integer.parseInt(st.nextToken()); // 고속도로 길이

        st = new StringTokenizer(br.readLine());
        places = new int[n+2];

        places[0] = 0;
        places[n+1] = l;
        for (int i = 1; i <= n; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(places);

        int result = getMinDist();
        System.out.println(result);
    }

    private static int getMinDist() {
        int left = 1;
        int right = l - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canBuild(mid) > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int canBuild(int mid) {
        int count = 0;

        for (int i = 1; i <= n+1; i++) {
            int temp = places[i] - places[i - 1];
            count += temp / mid;

            if( temp % mid == 0){
                count--;
            }
        }

        return count;
    }
}