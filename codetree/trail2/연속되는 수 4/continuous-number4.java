import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if(i >= 1 && (arr[i] > arr[i-1])){
                len++;
            }else{
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }

        maxLen = Math.max(maxLen, len);
        System.out.println(maxLen);
    }
}