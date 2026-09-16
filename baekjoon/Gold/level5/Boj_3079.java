package baekjoon.gold.level5;

import java.io.*;
import java.util.*;

// 3079. 입국심사
public class Boj_3079 {
    static int n, k;
    static int[] timeGroup;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 심사대 개수
        k = Integer.parseInt(st.nextToken()); // 심사를 받아야 할 사람 수

        timeGroup = new int[n]; // 각 심사대에서 한 사람을 처리하는 데 걸리는 시간 배열
        long maxTime = 0; // 가장 오래 걸리는 심사 시간을 저장할 변수

        for (int i = 0; i < n; i++) {
            timeGroup[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, timeGroup[i]); // 최대 처리 시간 갱신
        }

        Arrays.sort(timeGroup); // 시간 배열 정렬 (선택 사항, 필요는 없음)

        long temp = getMinTime(maxTime); // 최소 시간 계산
        System.out.println(temp);
    }

    /**
     * 주어진 심사대와 사람 수에 대해 최소 심사 시간을 계산하는 메서드
     * @param maxTime 각 심사대에서 가장 오래 걸리는 처리 시간
     */
    private static long getMinTime(long maxTime) {
        long left = 0; // 가능한 최소 소요시간 (가장 작은 범위)
        long right = maxTime * k; // 가능한 최대 소요시간 (최악의 경우)

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long available = 0; // 현재 시간(mid) 내에 처리할 수 있는 총 사람 수 계산
            for (int time : timeGroup) {
                available += mid / time; // 각 심사대가 처리 가능한 인원을 더함
                if (available >= k) { // 이미 필요한 인원 이상 처리 가능하면 더 계산할 필요 없음
                    break;
                }
            }
            if (available >= k) { // 모든 사람을 처리할 수 있는 경우
                right = mid - 1; // 더 짧은 시간에서 탐색
            } else { // 처리할 수 없는 경우
                left = mid + 1; // 더 긴 시간에서 탐색
            }
        }

        return right + 1;
    }
}