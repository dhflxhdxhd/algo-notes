import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = new int[]{1,0,-1,0}; // 동남서북
        int[] dy = new int[]{0,-1,0,1};
        int cells = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count = 0;

                for(int d=0; d<4; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if( inRange(nx, ny, n) && arr[nx][ny] == 1){
                        count++;
                        if(count >= 3){
                            cells++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.print(cells);
    }

    public static boolean inRange(int x, int y, int n){
        return x >= 0 && y >= 0 &&  x < n && y < n;
    }

}