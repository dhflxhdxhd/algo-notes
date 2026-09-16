package baekjoon.silver.level2;

import java.io.*;
import java.util.*;

// 12933. 오리
public class Boj_12933 {

    static char[] quack = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[] target = sc.next().toCharArray();

        if (target.length % 5 != 0 || target[0] != 'q') {
            System.out.println(-1);
            return;
        }

        int result = countDucks(target);
        System.out.println(result);
    }

    private static int countDucks(char[] target) {
        int count = 0;
        int remain = target.length;
        while (remain >= 5) {
            int order = 0;
            for (int i = 0; i < target.length; i++) {
                if (target[i] == quack[order % 5]) {
                    order++;
                    remain--;
                    target[i] = '0';
                }
            }

            if(order % 5 != 0){
                return -1;
            }else{
                count++;
            }
        }

        if (count == 0) {
            return -1;
        } else {
            return count;
        }
    }
}
