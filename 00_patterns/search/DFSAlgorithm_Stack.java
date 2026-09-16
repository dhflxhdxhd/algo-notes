package basic.search;

import java.util.Stack;

public class DFSAlgorithm_Stack {
    static boolean[] visited = new boolean[9];
    static int[][] graph ={{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    static Stack<Integer> stack = new Stack<>();
    static int startNode = 1;
    public static void main(String[] args) {
        stack.push(startNode);
        visited[startNode] = true;

        while(!stack.isEmpty()){
            int nodeIndex = stack.pop();

            System.out.print(nodeIndex + " - ");

            for (int node : graph[nodeIndex]){
                if(!visited[node]){
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }
}
