import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String removeStr = br.readLine();

        StringBuilder sb = new StringBuilder();
        int removeLen = removeStr.length();

        for (int i = 0; i < origin.length(); i++) {
            sb.append(origin.charAt(i));

            // 폭발 문자열과 길이가 같아지면 비교
            if (sb.length() >= removeLen) {
                boolean match = true;
                for (int j = 0; j < removeLen; j++) {
                    if (sb.charAt(sb.length() - removeLen + j) != removeStr.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // 폭발 문자열이 존재하면 제거
                if (match) {
                    sb.setLength(sb.length() - removeLen);  // 마지막 removeLen 길이만큼 삭제
                }
            }
        }

        // 결과 출력
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}