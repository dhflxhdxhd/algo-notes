import java.io.*;
import java.util.*;
public class Main {
	static boolean[] isSelected; // 숫자가 선택되었는지 판단하는 배열
	static int[] numbers; // 숫자가 들어있는 배열
	static int n,s, count; // 원소의 개수, 최종 합, 부분집합의 합이 최종 합인 부분집합의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		
		isSelected = new boolean[n];
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		count = 0;
		makePowerSet(0);
		System.out.println(count);
	}
	
	/**
	 * 부분집합을 구하는 메소드
	 * @param cnt 현재까지 고려한 원소 수
	 */
	static void makePowerSet(int cnt) {
		if(cnt == n) {
			// 출력
			int sum = 0;
			int falseCnt = 0;
			for (int i = 0; i < n; i++) {
				if(!isSelected[i]) {
					// 공집합인지 구하는 방법
					falseCnt++;
				}else {
					sum += numbers[i];
				}
			}
			
			// 공집합 제외
			if(falseCnt != n) {
				// 부분집합의 합이 최종 합이라면 count 증가
				if(sum == s) {
					count++;
				}
			}
			return;
		}
		
		// cnt번째 원소를 선택한 경우
		isSelected[cnt] = true;
		makePowerSet(cnt+1);
		// cnt번째 원소를 선택하지 않은 경우
		isSelected[cnt] = false;
		makePowerSet(cnt+1);
	}
}
