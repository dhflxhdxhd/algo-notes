package baekjoon.silver.level5;

import java.io.*;
import java.util.*;

// 1789. 수들의 합
public class Boj_1789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int result = getCount(S);
        System.out.println(result);
    }

    private static int getCount(long S) {
        long currentSum = 0;
        int currentNumber = 0;

        while (currentSum <= S) {
            currentNumber++;
            currentSum += currentNumber;
        }

        return currentNumber - 1;
    }
}

