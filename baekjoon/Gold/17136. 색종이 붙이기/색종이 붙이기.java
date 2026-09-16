
import java.io.*;
import java.util.*;

// 17136. 색종이 붙이기
public class Main{

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
     *
     * @param row 행
     * @param col 열
     */
    private static void putPaper(int row, int col, int count){
        if(count >= result) return;

        if(row >= N-1 && col > N-1 ){
            result = Math.min(result, count);
            return;
        }

        if(col >= N){
            putPaper(row+1, 0, count);
            return;
        }

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
            putPaper(row, col+1, count);
        }
    }

    private static void doAttach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                map[i][j] = 2;
            }
        }
    }

    private static void doDetach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                map[i][j] = 1;
            }
        }
    }

    private static boolean canAttach(int row, int col, int length){
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if(!isInArea(i,j) || map[i][j] != 1) return false;
            }
        }
        return true;
    }

    private static boolean isInArea(int row, int col){
        return row >= 0 && row <N && col >= 0 && col < N;
    }
}
