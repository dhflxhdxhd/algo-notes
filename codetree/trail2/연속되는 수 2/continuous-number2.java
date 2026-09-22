import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxCount = 1;
        int maxNum = arr[0];
        int count = 1;
        for(int i=1; i<n; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }else{
                if(maxCount < count){
                    maxCount = count;
                    maxNum = arr[i-1];
                }
                count = 1;
            }
        }

        // 마지막 구간 확인
        if(maxCount < count){
            maxCount = count;
        }

        System.out.print(maxCount);
    }
}