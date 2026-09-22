import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + 1000;
        int ay1 = sc.nextInt() + 1000;
        int ax2 = sc.nextInt() + 1000;
        int ay2 = sc.nextInt() + 1000;
        int bx1 = sc.nextInt() + 1000;
        int by1 = sc.nextInt() + 1000;
        int bx2 = sc.nextInt() + 1000;
        int by2 = sc.nextInt() + 1000;

        int[][] arr = new int[2001][2001];
        for(int i=ax1; i<ax2; i++){
            for(int j=ay1; j<ay2; j++){
                arr[i][j] = 1;
            }
        }

        for(int i=bx1; i<bx2; i++){
            for(int j=by1; j<by2; j++){
                arr[i][j] = 2;
            }
        }

    
        // 1이 남아있는 구역의 최소 x,y 최대 x,y 구하기
        int minX = 2001;
        int minY = 2001;
        int maxX = 0;
        int maxY = 0;
        boolean exist = false;
        for(int i=0; i<2001; i++){
            for(int j=0; j<2001; j++){
                if(arr[i][j] == 1){
                    exist = true;
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);

                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if(!exist){
            System.out.print(0);
        }else{
            System.out.print((maxX - minX + 1) * (maxY - minY + 1));
        }
    }
}