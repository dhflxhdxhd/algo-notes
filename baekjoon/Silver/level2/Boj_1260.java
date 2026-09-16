package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1260 {

    static int n, m, v; // 정점의 개수, 간선의 개수, 탐색을 시작할 정점 번호
    static boolean[] visited;
    static int[][] graph;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        // 그래프 구성
        for(int i = 1; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        System.out.println(dfs(v));
        System.out.println(bfs(v));
    }

    // queue
    static String bfs(int targetNode){
        visited = new boolean[n+1];
        sb = new StringBuilder();
        queue.offer(targetNode);
        visited[targetNode] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i = 1; i < m; i++) {
                int temp = graph[node][i];

                if(temp == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return sb.toString().trim();
    }

    // stack
    static String dfs(int startNode){
        visited = new boolean[n+1];
        sb = new StringBuilder();
        stack.push(startNode);

        while(!stack.isEmpty()){
            int target = stack.pop();
            sb.append(target).append(" ");
            visited[target] = true;

            for (int i = 1; i < m; i++) {
                if(!visited[i] && graph[target][i] == 1){
                    stack.push(i);
                }
            }
        }

        return sb.toString().trim();
    }
}




