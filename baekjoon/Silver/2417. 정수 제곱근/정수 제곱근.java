
import java.io.*;
import java.util.*;

// 2417. 정수 제곱근
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long result = getSqrtNum(n);
        System.out.println(result);
    }

    private static long getSqrtNum(long n) {
        long left = 1;
        long right = n;
        long result = 0;
        while(left <= right){
            long mid = left + (right - left) / 2;

            if(Math.pow(mid, 2) >= n){
                result = mid;
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
}
