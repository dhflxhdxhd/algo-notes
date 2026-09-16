
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] members = new String[5];

        for(int i=0; i<5; i++){
            members[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i=0; i<5; i++){
            if(isFBI(members[i])){
                check = true;
                sb.append(i+1).append(" ");
            }
        }

        System.out.println(check ? sb.toString() : "HE GOT AWAY!");
    }

    private static boolean isFBI(String member){
        String regex = ".*FBI.*";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(member);

        while(matcher.find()){
            return true;
        }
        return false;
    }
}
