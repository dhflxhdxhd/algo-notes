package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
    static int n, k;
    static Queue<Integer> queue;
    static int[] route;
    final static int Max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        route = new int[Max + 1];
        for (int i = 0; i <= Max; i++) {
            route[i] = -1;
        }

        if (n == k) {
            System.out.println(0);
            return;
        }
        int min = bfs();
        System.out.print(min);
    }

    static int[] dr = {-1, +1};
    static int bfs(){
        queue = new LinkedList<>();
        queue.offer(n);
        route[n] = 0; // 시작점 0

        while(!queue.isEmpty()){
            int sr = queue.poll();

            for (int d = 0; d < 3; d++) {
                int nr;
                if(d == 2){
                    nr = sr*2;
                }else{
                    nr = sr + dr[d];
                }
                // 동생을 만나면 종료
                if(nr == k){
                    return route[sr] + 1;
                }
                if(isInArea(nr) && route[nr] == -1){
                    queue.offer(nr);
                    route[nr] = route[sr] + 1;
                }
            }
        }
        return -1;  // 만나지 못하면 -1
    }
    static boolean isInArea(int row) {
        return row >= 0 && row <= Max;
    }
}
