
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

// 9342. 염색체
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < t; i++) {
            String target = br.readLine();

            String result = checkTarget(target) ? "Infected!" : "Good";

            if(i == t-1){
                sb.append(result);
                continue;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean checkTarget(String target){
        String pattern = "^[A-F]?A+F+C+[A-F]?$";

        return Pattern.matches(pattern, target);
    }
}
