import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            y1[i] = sc.nextInt() + 100;
            x2[i] = sc.nextInt() + 100;
            y2[i] = sc.nextInt() + 100;
        }

        int[][] arr = new int[201][201];
        for(int i= 0; i<n; i++){
            for(int x= x1[i]; x<x2[i]; x++){
                for(int y=y1[i]; y<y2[i]; y++){
                    arr[x][y] =  1;
                }
            }
        }

        int size = 0;
        for(int i=0; i<201; i++){
            for(int j=0; j<201; j++){
                if(arr[i][j] == 1){
                    size++;
                }
            }
        }

        System.out.println(size);
    }
}