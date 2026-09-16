package baekjoon.silver.level1;

import baekjoon.model.BoardNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static BoardNode[][] parent; // 최단 경로 저장 배열
    static Queue<BoardNode> queue = new LinkedList<>();

    // 상우하좌
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // row
        m = Integer.parseInt(st.nextToken()); // col

        maze = new int[n][m];
        visited = new boolean[n][m];
        parent = new BoardNode[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
        printPath(n - 1, m - 1);
    }

    static int bfs(int r, int c) {
        queue.offer(new BoardNode(r, c));
        visited[r][c] = true;
        maze[r][c] = 1;

        while (!queue.isEmpty()) {
            BoardNode node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node.row + dr[d];
                int nc = node.col + dc[d];

                if (isInArea(nr, nc) && !visited[nr][nc] && maze[nr][nc] == 1) {
                    queue.offer(new BoardNode(nr, nc));
                    visited[nr][nc] = true;
                    maze[nr][nc] = maze[node.row][node.col] + 1;
                    parent[nr][nc] = node;

                    if (nr == n - 1 && nc == m - 1) {
                        return maze[nr][nc];
                    }
                }
            }
        }
        return -1;
    }

    static void printPath(int row, int col) {
        if (parent[row][col] != null) {
            printPath(parent[row][col].row, parent[row][col].col);
        }
        System.out.println("(" + row + ", " + col + ")");
    }

    static boolean isInArea(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
