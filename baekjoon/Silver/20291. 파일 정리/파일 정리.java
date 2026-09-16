
import java.io.*;
import java.util.*;

// 20291. 파일 정리
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < t; i++) {
            String str = br.readLine().split("\\.")[1];

            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }

        List<String> sortedMap = new ArrayList<>(map.keySet());
        Collections.sort(sortedMap);

        StringBuilder sb = new StringBuilder();
        for(String k : sortedMap){
            int value = map.get(k);
            sb.append(k).append(" ").append(value).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length()-1).toString());

    }
}
