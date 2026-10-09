import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        
        int max = 0;
        for(int i=0; i<a.length(); i++){
            char[] bits = a.toCharArray();

            if(bits[i] == '0'){
                bits[i] = '1';
            }else{
                bits[i] = '0';
            }

            int num = 0;

            for(int j=0; j<bits.length; j++){
                int t = bits[j] - '0';
                num = 2*num + t;
            }

            max = Math.max(max, num);
        }


        System.out.println(max);
    }




}