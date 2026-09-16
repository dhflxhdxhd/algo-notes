import java.io.*;
import java.util.*;

// 1987. 알파벳
public class Main {
    static int r,c; // 세로, 가로
    static int maxCount = 1;
    static int[][] map;
    static int[] alphas; // 알파벳 방문을 체크하는 배열 (정수형으로 저장)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        map = new int[r][c];
        alphas = new int[26];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        alphas[map[0][0]] = 1;
        getMaxCount(0,0,1);
        System.out.println(maxCount);
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static void getMaxCount(int row, int col, int count){
        if(count == 26){
            maxCount = 26;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            // 이동할 좌표 값이 경계를 벗어난다면
            if(!isInArea(nr,nc)) continue;

            // 방문한 적이 있다면
            if(alphas[map[nr][nc]] == 1){
                maxCount = Math.max(maxCount, count);
                continue;
            }

            alphas[map[nr][nc]] = 1;
            getMaxCount(nr, nc, count+1);
            alphas[map[nr][nc]] = 0;
        }
    }

    /**
     * 좌표 값이 경계 안에 있는지 확인하는 메소드
     * @param row 행
     * @param col 열
     * @return true 경계 안 false 경계 밖
     */
    private static boolean isInArea(int row, int col){
        return row>=0 && row < r && col>=0 && col < c;
    }
}
