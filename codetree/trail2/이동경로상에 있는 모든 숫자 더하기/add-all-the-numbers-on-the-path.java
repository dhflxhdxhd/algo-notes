import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 동남서북
        int[] dc = {1,0,-1,0};
        int[] dr = {0,1,0,-1};
        int dir = 3;

        int mid = (int) Math.ceil( (double) n / 2 ) - 1;
        int col = mid;
        int row = mid;
        int sum = board[row][col];

        for(int i=0; i<t; i++){
            char cmd = commands.charAt(i);

            if(cmd == 'L'){
                dir = (dir - 1 + 4) % 4;
            }else if(cmd == 'R'){
                dir = (dir + 1) % 4;
            }else if(cmd == 'F'){
                int ncol = col + dc[dir];
                int nrow = row + dr[dir];

                if(inRange(ncol, nrow, n)){
                    col = ncol;
                    row = nrow;
                    sum += board[row][col];
                }
            }
        }
        
        System.out.print(sum);


    }


    public static boolean inRange(int r, int c, int n){
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}