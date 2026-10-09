import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int count = 0;
        for (int i = 0; i < A.length() - 1; i++) {
            if (A.charAt(i) == '(' && A.charAt(i + 1) == '(') {
                for (int j = i + 2; j < A.length() - 1; j++) {
                    if (A.charAt(j) == ')' && A.charAt(j + 1) == ')') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}