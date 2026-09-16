import java.io.*;
import java.util.*;

// Node 클래스: 정점과 해당 정점까지의 가중치를 나타냄
class Node implements Comparable<Node>{
    int vertex; // 정점
    int weight; // 간선(가중치)

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + vertex + " , " + weight + ")";
    }

    // 가중치 기준 오름차순 정렬
    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}

/*
1238. 파티
아이디어 : 역방향 그래프를 활용
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수 (정점)
        int m = Integer.parseInt(st.nextToken()); // 단방향 도로 개수 (간선)
        int x = Integer.parseInt(st.nextToken()); // 목적지

        List<List<Node>> adjList = new ArrayList<>(n+1);
        List<List<Node>> reverseAdjList = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());

            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList.get(startNode).add(new Node(endNode, weight));
            reverseAdjList.get(endNode).add(new Node(startNode, weight)); // 역방향 그래프 생성
        }

        int[] distanceFromX = new int[n+1]; // 목적지 x에서 집으로 돌아오는 최단경로
        int[] distanceToX = new int[n+1]; // 모든 마을에서 목적지 x로 가는 최단 경로(역방향 그래프 활용)
        Arrays.fill(distanceFromX, Integer.MAX_VALUE);
        Arrays.fill(distanceToX, Integer.MAX_VALUE);

        dijkstra(adjList, distanceFromX, x);
        dijkstra(reverseAdjList, distanceToX, x);

        int[] roundDistance = new int[n+1];
        Arrays.fill(roundDistance, 0);
        for (int i = 1; i < n+1; i++) {
            if(i==x){
                continue;
            }
            roundDistance[i] = distanceFromX[i] + distanceToX[i];
        }

        int maxDistance = Arrays.stream(roundDistance).max().getAsInt();
        System.out.println(maxDistance);
    }

    private static void dijkstra(List<List<Node>> adjList, int[] distance, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cNode = pq.poll();
            int cVertex = cNode.vertex;
            int cWeight = cNode.weight;

            for (Node adjNode : adjList.get(cVertex)){
                int newDist = cWeight + adjNode.weight;

                if(newDist < distance[adjNode.vertex]){
                    distance[adjNode.vertex] = newDist;
                    pq.add(new Node(adjNode.vertex, newDist));
                }
            }
        }
    }
}