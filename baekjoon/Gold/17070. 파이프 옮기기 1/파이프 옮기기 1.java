
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int count = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        movePipe(0, 1, 0);
        System.out.println(count);
    }

    /**
     * @param r   행
     * @param c   열
     * @param dir 가로 0 | 세로 1 | 대각선 2
     */
    private static void movePipe(int r, int c, int dir) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }

        if (dir == 0) {
            // 가로, 대각선
            if (isInArea(r, c + 1) && map[r][c + 1] == 0) {
                movePipe(r, c + 1, 0);
            }

            if (isInArea(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
                movePipe(r + 1, c + 1, 2);
            }
        } else if (dir == 1) {
            // 세로, 대각선
            if (isInArea(r + 1, c) && map[r + 1][c] == 0) {
                movePipe(r + 1, c, 1);
            }

            if (isInArea(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
                movePipe(r + 1, c + 1, 2);
            }
        } else {
            // 가로, 세로, 대각선
            if (isInArea(r, c + 1) && map[r][c + 1] == 0) {
                movePipe(r, c + 1, 0);
            }

            if (isInArea(r + 1, c) && map[r + 1][c] == 0) {
                movePipe(r + 1, c, 1);
            }

            if (isInArea(r + 1, c + 1) && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
                movePipe(r + 1, c + 1, 2);
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
