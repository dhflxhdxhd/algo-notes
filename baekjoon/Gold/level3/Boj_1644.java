package baekjoon.gold.level3;

import java.io.*;
import java.util.*;
// 1644. 소수의 연속합
public class Boj_1644 {

    static boolean[] primes;
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        primes = new boolean[N+1];
        makePrimes(N);


        if(N == 1){
            System.out.println(0);
        }else if(N <= 3){
            System.out.println(1);
        }else{
            int result = findPrimeSumWays(N);
            System.out.println(result);
        }
    }

    private static int findPrimeSumWays(int N){
        int result = 0; // 연속된 소수로 N을 만들 수 있는 경우의 수

        int sum = primeList.get(0);
        int left = 0;
        int right = 1;
        int listSize = primeList.size();

        while (right < listSize){
            sum += primeList.get(right++);
            while(sum > N && left < right){
                sum -= primeList.get(left++);
            }
            if(sum == N){
                result++;
            }
        }

        return result;
    }

    private static void makePrimes(int N) {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
    }
}
