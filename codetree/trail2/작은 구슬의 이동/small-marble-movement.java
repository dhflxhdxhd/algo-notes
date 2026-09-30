import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int x = sc.nextInt() -1;
        int y = sc.nextInt() -1;
        String D = sc.next();

        // 초기 1행 2열 , 왼쪽 바라봄
         // 왼 아래 위 오
        int[] dx = {0, 1,-1,0};
        int[] dy = {-1, 0, 0, 1};
        int dirNum =  getDirNum(D); // 왼쪽 
        
        for(int t=T; t>0; t--){
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(inRange(nx, ny, N)){
                x = nx;
                y = ny;
            }else{
                dirNum = 3 - dirNum;
            }
        }

        System.out.print((x+1) + " " + (y+1));
    
    }
    public static int getDirNum(String D){
        if(D.equals("U")){
            return 2;
        }else if(D.equals("D")){
            return 1;
        }else if(D.equals("R")){
            return 3;
        }else{
            return 0;
        }
    }
    
    public static boolean inRange(int x, int y, int n){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}