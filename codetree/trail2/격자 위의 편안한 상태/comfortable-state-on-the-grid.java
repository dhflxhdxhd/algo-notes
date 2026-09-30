import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] points = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt() -1;
            points[i][1] = sc.nextInt() -1;
        }
        
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        int[][] arr = new int[n][n]; // 색칠 격자 -> 색칠 : 1
        for(int p=0; p<m; p++){
            int count = 0; // 색칠 영역 수
            int r = points[p][0];
            int c = points[p][1];

            arr[r][c] = 1;
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(inRange(nr, nc, n) && arr[nr][nc] == 1){
                    count++;
                }
            }

            if(count == 3){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }



    }

    public static boolean inRange(int r, int c, int n){
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}