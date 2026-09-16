import java.io.*;
import java.util.*;
// 암호만들기
public class Main {

	static char[] picked; // 선택할 배열
	static char[] chars; // 입력으로 주어지는 배열
	static int l,c; // 암호 길이, 문자 개수
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken()); // 암호 길이
		c = Integer.parseInt(st.nextToken()); // 주어지는 문자 개수
		
		st = new StringTokenizer(br.readLine());
		chars = new char[c];  // 입력으로 주어지는 배열 초기화 -> c길이만큼
		picked = new char[l]; // 선택할 배열 초기화 -> 암호 길이만큼
		for (int i = 0; i < c; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		
		// 암호가 정렬된 형태이기 때문에 처음에 chars 배열 오름차순 정렬
		Arrays.sort(chars);
		// 암호로 만들 수 있는 조합 만들기
		makeCombi(0,0);
		
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
	}
	
	/**
	 * 길이가 l인 암호 조합 만들기
	 * @param cnt 현재 선택한 길이
	 * @param start 문자를 선택할 시작 인덱스
	 */
	static void makeCombi(int cnt, int start) {
		
		// 만약 암호 길이가 l로 완성되면
		if(cnt == l) {
			// 암호 유효성 체크
			if(checkValid(picked)) {
				// 해당 암호 유효한 암호 -> 출력값에 추가
				sb.append(picked).append("\n");
				return;
			}
			
			// 그렇지 않을 경우 그냥 return
			return;
		}
		
		// 조합 고르기 -> 중복 x, 순서 o
		for (int i = start; i < c ; i++) {
			picked[cnt] = chars[i];
			makeCombi(cnt+1, i+1);
		}
	}

	/**
	 * 암호 유효성 체크하는 메소드
	 * 자음이 최소 2개 이상, 모음이 최소 1개 이상인지 확인
	 * @param picked 길이가 l인 선택된 암호 조합
	 * @return true 유효함 false 유효하지 않음
	 */
	static boolean checkValid(char[] picked) {
		int vo = 0; // 모음 개수
		int co = 0; // 자음 개수
		
		// 선택된 문자 중
		for (char c : picked) {
			// 모음이면 vo 증가 아니면 co 증가
			if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c=='u' ) {
				vo++;
			}else {
				co++;
			}
		}
		
		// 모음이 1개 이상 && 자음이 2개 이상이라면 
		if(vo >= 1 && co >= 2) {
			// true 반환
			return true;
		}
		// 아니면 false 반환
		return false;
	}
}
