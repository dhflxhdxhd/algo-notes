package baekjoon.silver.level2;

/*
2512. 예산
정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정
모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
 */

import java.io.*;
import java.util.*;

public class Boj_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int regions = Integer.parseInt(br.readLine()); // 지방의 수

        int[] budgets = new int[regions]; // 각 지방의 요청 예산
        st = new StringTokenizer(br.readLine());
        for (int r = 0; r < regions; r++) {
            budgets[r] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets); // 이진 탐색을 이용하기 위해 정렬

        int fullBudget = Integer.parseInt(br.readLine());
        int limit = 0; // 상한액

        // 지방의 모든 요청을 배정할 수 있다면 배정
        if(canAllocate(budgets, fullBudget)){
            limit = budgets[regions-1]; // 상한액 = 지방의 요청 예산 최댓값
        }else{
            limit = getAllocationCap(budgets[regions-1], budgets, fullBudget);
        }
        System.out.println(limit);
    }

    /**
     * 각 지방의 예산 요청을 모두 충족할 수 있는지 판단하는 메소드
     * @param budgets 각 지방의 요청 예산
     * @param fullBudget 총 예산
     * @return true 배정 가능 false 배정 불가
     */
    private static boolean canAllocate(int[] budgets, int fullBudget){
        int sum = Arrays.stream(budgets).sum();
        if(sum <= fullBudget){
            return true;
        }
        return false;
    }

    /**
     * 특정한 정수 상한액을 판단하는 메소드
     * @param limit 상한액
     * @param budgets 각 지방의 요청 예산
     * @param fullBudget 총 예산
     * @return 상한액
     */
    private static int getAllocationCap(int limit, int[] budgets, int fullBudget){
        int left = 0;
        int right = limit;

        // 이분 탐색 이용
        while(left <= right ){
            int mid = left + (right - left) / 2; // 중간값
            int temp = estimateBudget(mid, budgets);

            if( temp > fullBudget){
                right = mid -1;
            }else{
                left = mid + 1;
            }
         }
        return right;
    }

    /*
     * 임시 상한액을 기준으로 배정할 수 있는 총 예산
     * @param allocationCap 임시 상한액
     * @param budgets 각 지방의 요청 예산
     * @return 총 예산 임시 산정값
     */
    private static int estimateBudget(int allocationCap, int[] budgets){
        int estBudget = 0;
        for (int b = 0; b < budgets.length ; b++) {
            estBudget += Math.min(budgets[b], allocationCap);
        }
        return estBudget;
    }
}
