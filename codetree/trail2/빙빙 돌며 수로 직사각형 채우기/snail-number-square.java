import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열
        int[][] arr = new int[n][m];
        arr[0][0] = 1;

        // 동 남 서 북 
        int[] dx = {0, 1, 0, -1}; // 행
        int[] dy = {1, 0, -1, 0}; // 열
        int dirNum = 0;

        int x = 0;
        int y = 0;
        for(int i=2; i<=n*m; i++){
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(!inRange(nx, ny, n, m)  || arr[nx][ny] != 0){
                dirNum = (dirNum + 1) % 4;
                nx = x + dx[dirNum];
                ny = y + dy[dirNum];
            }

            arr[nx][ny] = i;
            x = nx;
            y = ny;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static boolean inRange(int x, int y, int n, int m){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}