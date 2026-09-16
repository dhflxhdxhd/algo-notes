import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[2001];
        int current = 1000;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            if(dir == 'R'){
                for(int c=0; c<x; c++){
                    arr[current]++;
                    current++;
                }
            }else{
                for(int c=0; c<x; c++){
                    current--;
                    arr[current]++;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i <= 2000; i++) {
            if (arr[i] >= 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}