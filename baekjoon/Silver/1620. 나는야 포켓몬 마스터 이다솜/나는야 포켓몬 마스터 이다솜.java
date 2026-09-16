
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 1620. 나는야 포켓몬 마스터 이다솜
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int m = Integer.parseInt(st.nextToken()); // 맞춰야 할 문제 수

        HashMap<String, String> dic = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            String number = String.valueOf(i);
            dic.put(number, name);
            dic.put(name, number);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            sb.append(dic.get(target));

            if(i < m-1){
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
