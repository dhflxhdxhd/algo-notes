import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2467. 용액
a : A 용액 c(ml)의 특성값
b : B 용액 c(ml)의 특성값
용액 A와 용액 B를 혼합한 용액의 특성값 = a + b
 */
public class Main {

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
     * 특성값이 0에 가까운 용액을 구하는 메소드
     * @param num 전체 용액의 수
     * @param sValues 각 용액의 특성값이 들어있는 정수형 배열
     */
    private static void getSolutions(int num, int[] sValues){
        int left = 0;
        int right = num -1; // sValues에서 마지막 용액의 위치
        int target = 0; // 목표 특성값
        int minGap = Integer.MAX_VALUE; // 가장 큰 용액의 크기 + 1

        while(left < right){
            int tempValue = sValues[left] + sValues[right]; // 두 용액 혼합 시 특성값
            int tempGap = Math.abs(tempValue);

            // 두 용액을 혼합한 특성값이 0이라면 더이상 최선의 조합은 없음.
            if(tempValue == target){
                solutions[0] = left;
                solutions[1] = right;
                return;
            }

            if(minGap > tempGap){
                solutions[0] = left;
                solutions[1] = right;
                minGap = tempGap;
            }

            if(tempValue > 0){
                right--;
            }else{
                left++;
            }
        }
    }
}