package baekjoon.gold.level5;

import java.io.*;
import java.util.*;

/*
2467. 용액
a : A 용액 c(ml)의 특성값
b : B 용액 c(ml)의 특성값
용액 A와 용액 B를 혼합한 용액의 특성값 = a + b
 */
public class Boj_2467_Binary {
    static int[] solutions = new int[2]; // 특성값이 0에 가까운 용액의 위치(인덱스)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); // 전체 용액의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sValues = new int[num]; // 각 용액의 특성값 (정렬된 상태로 입력이 주어짐)

        for (int s = 0; s < num ; s++) {
            sValues[s] = Integer.parseInt(st.nextToken());
        }

        getSolutions(num, sValues);
        System.out.println(sValues[solutions[0]]+ " "+ sValues[solutions[1]]);
    }

    /**
     * 특성값이 0에 가까운 용액을 구하는 메소드 (이분탐색)
     * -> 각 타겟값을 지정해서 타겟값과 섞었을 때 특성값이 0에 가까운 용액의 조합을 구함
     * @param num 전체 용액의 수
     * @param sValues 각 용액의 특성값이 들어있는 정수형 배열
     */
    private static void getSolutions(int num, int[] sValues) {
        int minGap = Integer.MAX_VALUE;

        for (int vIdx = 0; vIdx < num -1; vIdx++) {
            int targetValue = sValues[vIdx];
            int left = vIdx + 1;
            int right = num -1;

            while(left <= right){
                int mid = left + (right - left) / 2;
                int tempValue = targetValue + sValues[mid];
                int tempGap = Math.abs(tempValue);

                if(minGap > tempGap){
                    minGap = tempGap;
                    solutions[0] = vIdx;
                    solutions[1] = mid;
                }

                if(tempValue < 0){
                    left = mid + 1;
                }else if(tempValue > 0){
                    right = mid - 1;
                }else{
                    // 두 용액을 혼합한 특성값이 0이라면 더이상 최선의 조합은 없음.
                    return;
                }
            }
        }
    }
}

/*
[반례 입/출력값]
입력값
5
-100  -99  -50  -2  -1

출력
-2 -1
 */
