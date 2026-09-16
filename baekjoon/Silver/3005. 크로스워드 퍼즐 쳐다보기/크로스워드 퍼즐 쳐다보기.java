
import java.io.*;
import java.util.*;

// 3005. 크로스워드 퍼즐 쳐다보기
public class Main {

    static char[][] map;
    static PriorityQueue<String> queue = new PriorityQueue<>(); // 사전 순 정렬 설정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        getWords(R,C);
        System.out.println(queue.poll());
    }
    private static void getWords(int R, int C) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            sb.setLength(0);
            for(int j=0; j<C; j++){
                if(map[i][j] == '#'){
                    if(sb.length() > 1){
                        queue.offer(sb.toString());
                    }
                    sb.setLength(0);
                }else{
                    sb.append(map[i][j]);
                }
            }

            if(sb.length() > 1){
                queue.offer(sb.toString());
            }
        }



        for(int j=0; j<C; j++){
            sb.setLength(0);
            for(int i=0; i<R; i++){
                if(map[i][j] == '#'){
                    if(sb.length() > 1){
                        queue.offer(sb.toString());
                    }
                    sb.setLength(0);
                }else{
                    sb.append(map[i][j]);
                }
            }


            if(sb.length() > 1){
                queue.offer(sb.toString());
            }
        }

    }

}
