import java.util.Scanner;
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
        int mx1 = sc.nextInt() + 1000;
        int my1 = sc.nextInt() + 1000;
        int mx2 = sc.nextInt() + 1000;
        int my2 = sc.nextInt() + 1000;

        final int MAX_LENGTH = 2001;
        int[][] arr = new int[MAX_LENGTH][MAX_LENGTH]; // 1(a), 2(b)
        
        int sumA = 0;
        int sumB = 0;
        for(int i=ax1; i<ax2; i++){
            for(int j=ay1; j<ay2; j++){
                arr[i][j] = 1;
                sumA++;
            }
        }

        for(int i=bx1; i<bx2; i++){
            for(int j=by1; j<by2; j++){
                arr[i][j] = 2;
                sumB++;
            }
        }

        for(int i=mx1; i<mx2; i++){
            for(int j=my1; j<my2; j++){
                if (arr[i][j] == 1) {
                    sumA--;
                } else if(arr[i][j] == 2){
                    sumB--;
                }

                arr[i][j] = 0;
            }
        }

        System.out.println(sumA + sumB);
    }
}