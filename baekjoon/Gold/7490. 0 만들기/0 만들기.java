import java.io.*;
import java.util.*;

// 7490. 0 만들기
public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test=0; test<T; test++){
            int N = Integer.parseInt(br.readLine());

            getExpression(N, 1, 1, 0,1,"1");
            if(test == T-1){
                continue;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void getExpression(int N,int idx,int number, int result, int operation, String expression){
        if(idx == N){
            result += number*operation;
            if(result == 0){
                sb.append(expression).append("\n");
            }
            return;
        }
        getExpression(N, idx+1, number*10+(idx+1), result , operation ,expression+" "+Integer.toString(idx+1));
        getExpression(N, idx+1, idx+1, result+(number*operation) , +1 ,expression+"+"+Integer.toString(idx+1));
        getExpression(N, idx+1, idx+1, result+(number*operation) , -1 ,expression+"-"+Integer.toString(idx+1));
    }
}
