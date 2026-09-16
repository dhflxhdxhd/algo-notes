package baekjoon.gold.level2;

import java.io.*;
import java.util.*;

// 1039. 교환
class CountNum{
    int number;
    int count;

    public CountNum(int number, int count) {
        this.number = number;
        this.count = count;
    }
}
public class Boj_1039 {

    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        getMaxValue(n,k);
        int result = maxValue == Integer.MIN_VALUE ? -1 : maxValue;
        System.out.println(result);
    }

    private static void getMaxValue(int n, int k){
        Queue<CountNum> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[1000000+1][k+1];
        Set<String> visited = new HashSet<String>();

        queue.offer(new CountNum(n,0));
//        visited[n][0] = true;
        visited.add(n+","+0);

        while(!queue.isEmpty()){
            CountNum current = queue.poll();
            int currentNum = current.number;
            int currentCount = current.count;

            if(currentCount == k){
                maxValue = Math.max(maxValue, currentNum);
                continue;
            }

            int len = String.valueOf(currentNum).length();
            for(int i=0; i<len-1; i++){
                for(int j=i+1; j<len; j++){
                    int swapNumber = swapPlaces(currentNum, i, j);
                    String nextSet = swapNumber+","+(currentCount+1);
                    if (swapNumber != 0 && !visited.contains(nextSet)){
                        queue.offer(new CountNum(swapNumber, currentCount+1));
                        visited.add(nextSet);
                    }
//                    if(swapNumber != 0 && !visited[swapNumber][currentCount+1]){
//                        queue.offer(new CountNum(swapNumber, currentCount+1));
//                        visited[swapNumber][currentCount+1] = true;
//                    }
                }
            }
        }
    }


    private static int swapPlaces(int number, int idx1, int idx2){
        int length = String.valueOf(number).length();

        // 각 자릿수 구하기
        int digit1 = (number / (int) Math.pow(10, idx1)) % 10;
        int digit2 = (number / (int) Math.pow(10, idx2)) % 10;

        if (digit1 == digit2) return number;

        number -= digit1 * (int) Math.pow(10, idx1);  // idx1 자리를 0으로
        number -= digit2 * (int) Math.pow(10, idx2);  // idx2 자리를 0으로

        number += digit1 * (int) Math.pow(10, idx2);  // idx1 값을 idx2 자리로 이동
        number += digit2 * (int) Math.pow(10, idx1);  // idx2 값을 idx1 자리로 이동

        if (number / (int) Math.pow(10, length - 1) == 0) return 0;

        return number;
    }
//    private static int swapPlaces(int number, int idx1, int idx2){
//        char[] numberArr = String.valueOf(number).toCharArray();
//        char temp = numberArr[idx1];
//        numberArr[idx1] = numberArr[idx2];
//        numberArr[idx2] = temp;
//
//        if(numberArr[0] == '0'){
//            return 0;
//        }else{
//            return Integer.parseInt(new String(numberArr));
//        }
//    }
}
