package basic.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm {
    private static int[][] graph;
    private static boolean[] visited;
    private static Queue<Integer> queue;
    public static void main(String[] args) {
        graph = new int[][]{{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
        visited = new boolean[9];

        System.out.println(bfs(1));

    }

    static String bfs(int startNode){
        StringBuilder sb = new StringBuilder();
        queue = new LinkedList<Integer>();

        visited[startNode] = true;
        queue.offer(startNode);

        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append("-");

            for (int i = 1; i<graph[node].length; i++){
                int temp = graph[node][i];

                // 방문하지 않았다면
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}



