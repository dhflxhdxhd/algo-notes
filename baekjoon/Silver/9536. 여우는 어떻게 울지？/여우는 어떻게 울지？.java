
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.setLength(0);  
            String str = br.readLine();
            List<String> words = List.of(str.split(" "));

            HashSet<String> bannedSounds = new HashSet<>();
            while (true) {
                str = br.readLine();
                if (str.equals("what does the fox say?")) break;

                st = new StringTokenizer(str);
                st.nextToken(); 
                st.nextToken(); 
                String sound = st.nextToken();
                bannedSounds.add(sound);
            }

            for (String word : words) {
                if (!bannedSounds.contains(word)) {
                    sb.append(word).append(" ");
                }
            }
            System.out.print(sb);
        }
    }
}