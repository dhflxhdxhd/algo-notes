
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
public class Main {

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
        Set<String> visited = new HashSet<String>();

        queue.offer(new CountNum(n,0));
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

                }
            }
        }
    }


    private static int swapPlaces(int number, int idx1, int idx2){
        int length = (int) Math.log10(number) + 1;

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
}
