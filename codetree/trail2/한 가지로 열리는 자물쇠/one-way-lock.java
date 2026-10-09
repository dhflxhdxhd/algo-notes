import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int total = n*n*n;
        int notOpen = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if (
                        Math.abs(i - a) > 2 &&
                        Math.abs(j - b) > 2 &&
                        Math.abs(k - c) > 2
                    ) {
                        notOpen++;
                    }
                }
            }
        }

        System.out.print(total - notOpen);
    }
}