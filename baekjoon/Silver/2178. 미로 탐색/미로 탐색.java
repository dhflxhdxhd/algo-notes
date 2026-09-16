import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class MazeNode {
    int row;
    int col;

    public MazeNode(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
}
// 2178. 미로탐색
public class Main {

    static int n,m;
    static int[][] maze;
    static boolean[][] visited;
    static Queue<MazeNode> queue = new LinkedList<MazeNode>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // row
        m = Integer.parseInt(st.nextToken()); // col

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    
    }

    // 상우하좌
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int bfs(int r, int c){
        queue.offer(new MazeNode(r,c));

        while(!queue.isEmpty()){
            MazeNode node = queue.poll();
            visited[node.row][node.col] = true;

            for (int d = 0; d < dr.length; d++) {
                int nr = node.row + dr[d];
                int nc = node.col + dc[d];

                if(isInArea(nr, nc)){
                    if(!visited[nr][nc] && maze[nr][nc] == 1){
                        queue.offer(new MazeNode(nr,nc));
                        visited[nr][nc] = true;

                        maze[nr][nc] = maze[node.row][node.col] + 1;
                        if (nr == n - 1 && nc == m - 1) {
                            return maze[nr][nc];
                        }
                    }
                }
            }
        }
        return -1;
    }

    static boolean isInArea(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}