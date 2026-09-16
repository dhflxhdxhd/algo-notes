
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for (int i = 0; i < T; i++) {
            stack.clear();
            check = false;
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                Character c = str.charAt(j);
                if(c.equals('(')){
                    stack.push(c);
                }else{
                    if(stack.size() > 0 ){
                        char top = stack.peek();
                        if(top == '('){
                            stack.pop();
                        }else{
                            sb.append("NO").append('\n');
                            check = true;
                            break;
                        }
                    }else{
                        sb.append("NO").append('\n');
                        check = true;
                        break;
                    }
                }
            }

            if(check) continue;

            if(stack.size() == 0){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
