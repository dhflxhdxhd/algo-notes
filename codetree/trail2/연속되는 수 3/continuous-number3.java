import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

            if(i >= 1 &&  ( ( arr[i] > 0 && arr[i-1] > 0 )  || ( arr[i] < 0 && arr[i-1] < 0 )  )  ){
                count++;
            }else{
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }

        maxCount = Math.max(count, maxCount);
        System.out.println(maxCount);
}
}