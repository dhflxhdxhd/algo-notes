package basic.search;

// 재귀버전
public class DFSAlgorithm {
    // 방문처리 배열
    static boolean[] visited = new boolean[9];
    // 그래프 연결 상태, 인덱스가 각각의 노드 번호
    static int[][] graph ={{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        dfs(1);
    }

    static void dfs(int nodeIndex){
        visited[nodeIndex] = true;

        System.out.print(nodeIndex + " - ");

        for (int node : graph[nodeIndex]){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}

