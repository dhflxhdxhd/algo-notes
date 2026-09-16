import java.io.*;
import java.util.*;

class BoardNode {
    int row;
    int col;

    public BoardNode(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}
// 1926. 그림
public class Main {
    static int n,m, num; // 세로, 가로
    static int[][] board;
    static Queue<BoardNode> queue = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = 2;
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1){
                    int size = bfs(i,j);
                    maxSize = Integer.max(maxSize, size);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int bfs(int row, int col) {
        int size = 1;
        queue.offer(new BoardNode(row, col));
        board[row][col] = num;

        while(!queue.isEmpty()){
            BoardNode tempNode = queue.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = tempNode.row + dr[d];
                int nc = tempNode.col + dc[d];

                if(isInArea(nr,nc) && board[nr][nc] == 1){
                    board[nr][nc] = num;
                    queue.offer(new BoardNode(nr,nc));
                    size++;
                }
            }

        }


        return size;
    }

    static boolean isInArea(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}