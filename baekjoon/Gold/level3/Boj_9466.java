package baekjoon.gold.level3;

import java.io.*;
import java.util.*;

// 9466. 텀 프로젝트
public class Boj_9466 {

    static boolean[] visited, finished; // 해당 노드를 방문 중인지 확인하는 배열, 완성된 사이클을 추적하는 배열
    static int[] members;
    static int n, result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++){
            result = 0;
            n = Integer.parseInt(br.readLine());
            members = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                members[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    checkCycle(i);
                }
            }
            sb.append(n-result).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length()-1).toString());
    }

    private static void checkCycle(int current){
        if(visited[current]) return;
        visited[current] = true;
        int next = members[current];

        if(!visited[next]){ // 다음이 아직 방문하지 않았으면 탐색
            checkCycle(next);
        }else if(!finished[next]){ // 사이클 형성
            for(int i = next; i != current; i=members[i]){
                result++;
            }
            result++;
        }

        finished[current] = true;
        visited[current] = false;
    }
}



