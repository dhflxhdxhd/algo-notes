package baekjoon.gold.level5;

import java.io.*;
import java.util.*;

// 7490. 0 만들기
public class Boj_7490_2 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test=0; test<T; test++){
            int N = Integer.parseInt(br.readLine());

            getAllExpression(N, 1, "1");
            if (test != T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void getAllExpression(int N, int currentNumber, String expression){
        if(currentNumber == N){
            if(calculateExpression(expression.replace(" ", "")) == 0) sb.append(expression).append("\n");
            return;
        }

        getAllExpression(N, currentNumber+1, expression+" "+(currentNumber+1));
        getAllExpression(N, currentNumber+1, expression+"+"+(currentNumber+1));
        getAllExpression(N, currentNumber+1, expression+"-"+(currentNumber+1));
    }

    private static int calculateExpression(String expression){
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder tempNumber = new StringBuilder();
        for(int i=0; i<expression.length(); i++){
            char current = expression.charAt(i);

            if(current == '+' || current == '-'){
                numbers.add(Integer.parseInt(tempNumber.toString()));
                tempNumber.setLength(0); // 숫자 초기화
                operators.add(current);
            }else{
                tempNumber.append(current);
            }
        }

        numbers.add(Integer.parseInt(tempNumber.toString()));

        // 계산
        int result = numbers.get(0);
        for(int i =0; i<operators.size(); i++){
            char currenntOp = operators.get(i);
            int nextNumber = numbers.get(i+1);
            if(currenntOp == '+'){
                result += nextNumber;
            }else{
                result -= nextNumber;
            }
        }
        return result;
    }
}
