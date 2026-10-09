import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int openCount = 0;
        int answer = 0;

        for (int i = 0; i < A.length() - 1; i++) {

            if (A.charAt(i) == '(' && A.charAt(i + 1) == '(') {
                openCount++;
            }

            if (A.charAt(i) == ')' && A.charAt(i + 1) == ')') {
                answer += openCount;
            }
        }

        System.out.println(answer);
    }
}