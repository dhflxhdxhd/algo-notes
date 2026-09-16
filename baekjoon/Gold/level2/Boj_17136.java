package baekjoon.gold.level2;

import java.io.*;
import java.util.*;

// 17136. 색종이 붙이기
public class Boj_17136{

    final static int N = 10;
    static int oneCell = 0;
    static int result = Integer.MAX_VALUE;
    static int[][] map = new int[N][N];
    static HashMap<Integer, Integer> paperCounts = new HashMap<>(); // 보유하고 있는 색종이 (사이즈, 개수)

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1){
                    oneCell++;
                }
            }
        }

        for (int i = 1; i <= 5; i++) {
            paperCounts.put(i, paperCounts.getOrDefault(i, 0) + 5);
        }

        if(oneCell == 0) System.out.println(0);
        else if(oneCell == N*N) System.out.println(4);
        else{
            putPaper(0,0, 0);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }
    }

    /**
     * 색종이를 붙이는 재귀 메소드
     * @param row 행
     * @param col 열
     */
    private static void putPaper(int row, int col, int count){
        // 최솟값을 구해야하는데, 현재 count가 result 이상이면 탐색 종료
        if(count >= result) return;

        // 모든 셀을 검사 완료하면 최소값 업데이트
        if(row >= N-1 && col > N-1 ){
            result = Math.min(result, count);
            return;
        }

        // 다음 행으로 이동
        if(col >= N){
            putPaper(row+1, 0, count);
            return;
        }

        // 현재 위치가 1이면 색종이를 붙일 수 있는지 검사 후, 재귀 호출
        if(map[row][col] == 1){
            for (int i = 5; i > 0 ; i--) {
                if(paperCounts.get(i) > 0 && canAttach(row, col, i)){
                    doAttach(row, col, i);
                    paperCounts.put(i, paperCounts.get(i)-1);
                    putPaper(row, col + 1, count + 1);
                    doDetach(row, col, i);
                    paperCounts.put(i, paperCounts.get(i)+1);
                }
            }
        }else{
            putPaper(row, col+1, count); // 1이 아니면 오른쪽으로 이동
        }
    }

    /**
     * 특정 위치에 주어진 크기의 색종이를 붙이는 메소드
     * @param row 시작 행
     * @param col 시작 열
     * @param length 색종이 크기
     */
    private static void doAttach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                map[i][j] = 2;
            }
        }
    }

    /**
     * 특정 위치에서 주어진 크기의 색종이를 떼는 메소드
     * @param row 시작 행
     * @param col 시작 열
     * @param length 색종이 크기
     */
    private static void doDetach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                map[i][j] = 1;
            }
        }
    }

    /**
     * 현재 위치에 주어진 크기의 색종이를 붙일 수 있는지 확인하는 메소드
     * @param row 시작 행
     * @param col 시작 열
     * @param length 색종이 크기
     * @return 색종이를 붙일 수 있으면 true, 아니면 false
     */
    private static boolean canAttach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if(!isInArea(i,j) || map[i][j] != 1) return false;
            }
        }
        return true;
    }

    /**
     * 좌표가 유효한 영역인지 검사하는 메소드
     * @param row 행
     * @param col 열
     * @return 유효한 좌표이면 true, 아니면 false
     */
    private static boolean isInArea(int row, int col){
        return row >= 0 && row <N && col >= 0 && col < N;
    }
}
