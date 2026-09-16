/*
2512. 예산
정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정
모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int regions = Integer.parseInt(br.readLine()); // 지방의 수

        int[] budgets = new int[regions]; // 각 지방의 요청 예산
        st = new StringTokenizer(br.readLine());
        for (int r = 0; r < regions; r++) {
            budgets[r] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        int fullBudget = Integer.parseInt(br.readLine());
        int maxAllocationCap = 0;

        // 지방의 모든 요청을 배정할 수 있다면 배정
        if(canAllocate(budgets, fullBudget)){
            maxAllocationCap = budgets[regions-1];
        }else{
            // 예산 최대 상한액 계산
            maxAllocationCap = getAllocationCap(budgets[regions-1], budgets, fullBudget);
        }
        System.out.println(maxAllocationCap);
    }

    // 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
    private static boolean canAllocate(int[] budgets, int fullBudget){
        int sum = Arrays.stream(budgets).sum();
        if(sum <= fullBudget){
            return true;
        }
        return false;
    }


    // 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
    // 상한액 반환하면 되겠네.
    private static int getAllocationCap(int maxAllocationCap, int[] budgets, int fullBudget){
        int left = 0;
        int right = maxAllocationCap;

        while(left < right -1 ){
            int mid = left + (right - left) / 2; // 중간값 구하기
//            System.out.println("mid " + mid);

            int temp = estimateBudget(mid, budgets);
            if( temp > fullBudget){
                right = mid;
            }else{
                left = mid;
            }
         }
        return left;
    }

    private static int estimateBudget(int allocationCap, int[] budgets){
        int estBudget = 0;
        for (int b = 0; b < budgets.length ; b++) {
            if(budgets[b] < allocationCap){
                estBudget += budgets[b];
            }else{
                estBudget += allocationCap;
            }
        }

        return estBudget;
    }


}