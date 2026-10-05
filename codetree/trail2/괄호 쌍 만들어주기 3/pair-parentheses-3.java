import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int count = 0;
        for(int i=0; i<A.length()-1; i++){
            char msg1 = A.charAt(i);
            if(msg1 == '('){
                for(int j=i+1; j<A.length(); j++){
                    char msg2 = A.charAt(j);
                    if(msg2 == ')'){
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}