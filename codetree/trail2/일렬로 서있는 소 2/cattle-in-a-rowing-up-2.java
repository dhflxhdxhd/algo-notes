import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i=0; i<n-2; i++){
            int cow1 = arr[i];
            for(int j=i+1; j<n-1; j++){
                int cow2 = arr[j];
                if(cow1 <= cow2){
                  for(int k=j+1; k<n; k++){
                        int cow3 = arr[k];
                        if(cow2 <= cow3){
                            count++;
                        }
                   }
                }

            }
        }

        System.out.print(count);

        
    }
}