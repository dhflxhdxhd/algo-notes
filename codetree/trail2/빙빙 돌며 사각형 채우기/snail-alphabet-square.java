import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        // 동남서북
        int[] dc = {1,0,-1,0};
        int[] dr = {0,1,0,-1};

        
        int r = 0;
        int c = 0;
        int dir = 0;

        arr[r][c] = 1;
        for(int i=2; i<=n*m; i++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(inRange(nr, nc, n,m) && arr[nr][nc] == 0){
                arr[nr][nc] = (i - 1) % 26 + 1;
                r = nr;
                c = nc;
            }else{
                dir = (dir + 1) % 4;

                nr = r + dr[dir];
                nc = c + dc[dir];
                arr[nr][nc] = (i - 1) % 26 + 1;

                r = nr;
                c = nc;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                System.out.print( (char) ('A' + arr[i][j] - 1) + " ");
            }
            System.out.println();
        }

    }

    public static boolean inRange(int nr, int nc, int n, int m){
        return nr >= 0 && nc >= 0 && nr < n && nc < m;
    }
}