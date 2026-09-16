
import java.io.*;
import java.util.*;

// 1253. 좋다
public class Main {

    static int N;
    static int[] numbers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        if(N <= 2){
            System.out.println(0);
        }else{
            int count = 0;
            for(int i=0; i<N; i++){
                if(isGood(i, numbers[i])) count++;
            }
            System.out.println(count);
        }
    }

    private static boolean isGood(int currentIdx, int currentNumber){
        int left = 0;
        int right = N-1;

        while(left < right){
            if(left == currentIdx){
                left++;
                continue;
            }

            if(right == currentIdx){
                right--;
                continue;
            }

            int sum = numbers[left] + numbers[right];
            if(sum == currentNumber){
                return true;
            } else if (sum > currentNumber) {
                right--;
            }else {
                left++;
            }
        }

        return false;
    }
}
