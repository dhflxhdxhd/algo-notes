
import java.io.*;

public class Main {
    static int maxCandies = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = st.charAt(j);
            }
        }

        findMaxCandies(map, n);
        changeMap(map, n);
        System.out.println(maxCandies);
    }

    private static void changeMap(char[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 가로로 인접한 사탕 교환
                if (map[i][j] != map[i][j + 1]) {
                    swap(map, i, j, i, j + 1);
                    findMaxCandies(map, n);
                    swap(map, i, j, i, j + 1);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != map[i + 1][j]) {
                    swap(map, i, j, i + 1, j);
                    findMaxCandies(map, n);
                    swap(map, i, j, i + 1, j);
                }
            }
        }
    }

    private static void findMaxCandies(char[][] map, int n) {
        for (int i = 0; i < n; i++) {
            int rowCount = 1, colCount = 1;
            for (int j = 1; j < n; j++) {
                if (map[i][j] == map[i][j - 1]) {
                    rowCount++;
                } else {
                    maxCandies = Math.max(maxCandies, rowCount);
                    rowCount = 1;
                }

                if (map[j][i] == map[j - 1][i]) {
                    colCount++;
                } else {
                    maxCandies = Math.max(maxCandies, colCount);
                    colCount = 1;
                }
            }
            maxCandies = Math.max(maxCandies, Math.max(rowCount, colCount));
        }
    }

    private static void swap(char[][] map, int x1, int y1, int x2, int y2) {
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }
}