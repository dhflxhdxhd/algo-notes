package baekjoon.silver.level2;

import java.io.*;
import java.util.*;

// 2644. 촌수계산
public class Boj_2644_BFS {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수


        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, -1);

        int m = Integer.parseInt(br.readLine()); // 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int kinship = calculateKinship(p1,p2);
        System.out.println(kinship);
    }

    private static int calculateKinship(int start, int end){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0; // 자기 자신과는 촌수 0

        while(!queue.isEmpty()){
            int p = queue.poll();

            for (int neighbor : graph.get(p)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    distance[neighbor] = distance[p] + 1;
                    queue.offer(neighbor);

                    if(neighbor == end){
                        return distance[neighbor];
                    }
                }
            }
        }

        return distance[end];
    }
}
