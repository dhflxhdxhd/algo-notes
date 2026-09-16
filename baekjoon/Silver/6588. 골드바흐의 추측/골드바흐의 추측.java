
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        numbers = new boolean[1000000 + 1];
        Arrays.fill(numbers, false);

        getPrimes();

        while (true) {
            Integer number = Integer.parseInt(br.readLine());

            if (number == 0) break;

            boolean found = false;
            for (int i = 3; i < number; i += 2) {
                if (!numbers[i] && !numbers[number - i]) {
                    sb.append(number).append(" = ").append(i).append(" + ").append(number - i).append("\n");
                    found = true;
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }


    /**
     * 에라토스테네스의 체를 이용한 소수 판별법
     */
    private static void getPrimes() {
        numbers[0] = numbers[1] = true;

        for (int i = 2; i * i <= 1000000; i++) {
            if (!numbers[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    numbers[j] = true;
                }
            }
        }
    }
}
