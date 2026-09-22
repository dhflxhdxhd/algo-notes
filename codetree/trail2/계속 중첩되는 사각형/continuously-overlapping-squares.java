import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int MAX_LEN = 201;
        int OFFSET = 100;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + OFFSET;
            y1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
            y2[i] = sc.nextInt() + OFFSET;
        }

        int[][] arr = new int[MAX_LEN][MAX_LEN];
        int countBlue = 0;
        for(int i = 0; i < n; i++){
            int currentColor; // 0 : N, 1: R, 2:B
            if(i%2 == 0){
                currentColor = 1;
            }else{
                currentColor = 2;
            }
            for(int x = x1[i]; x < x2[i]; x++){
                for(int y= y1[i]; y<y2[i]; y++){
                    arr[x][y] = currentColor;
                }
            }
        }

        for(int i=0; i<MAX_LEN; i++){
            for(int j=0; j<MAX_LEN; j++){
                if(arr[i][j] == 2){
                    countBlue++;
                }
            }
        }

        System.out.println(countBlue);
    }
}
