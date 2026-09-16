
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int value = n / 3;
        int rest = n % 3;
        String result = "SK";
        if(isOdd(value)){
            if(isOdd(rest)){
                result = "CY";
            }
        }else{
            if(!isOdd(rest)){
                result = "CY";
            }
        }

        System.out.println(result);
    }

    private static boolean isOdd(int number){
        return number % 2 > 0 ? true : false;
    }
}
