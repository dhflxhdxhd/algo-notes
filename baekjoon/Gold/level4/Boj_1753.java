package baekjoon.gold.level4;

import baekjoon.model.Node;

import java.util.*;
import java.io.*;

/*
1753. 최단경로
 */
public class Boj_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int start = Integer.parseInt(br.readLine()); // 시작 정점

        List<List<Node>> adjList = new ArrayList<>(V+1);
        // 인접리스트 초기화
        for (int i = 0; i <= V ; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] distance = new int[V+1]; // 각 정점까지의 최단 경로 비용
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Node(v,w));
        }

        dijkstra(adjList, distance, start);

        for (int i = 1; i <= V ; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }
    }

    /**
     * 다익스트라 알고리즘을 이용하여 시작 정점에서 다른 모든 정점까지의 최단 경로를 구하는 메소드
     * @param adjList 인접 리스트
     * @param distance 최단 경로 비용 배열
     * @param start 시작 정점
     */
    static void dijkstra(List<List<Node>> adjList, int[] distance, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, distance[start]));

        while (!pq.isEmpty()){
            Node cNode = pq.poll();
            int cVertex = cNode.vertex;
            int cWeight = cNode.weight;

            for (Node adjNode : adjList.get(cVertex)){
                int adjVertex = adjNode.vertex;
                int adjWeight = adjNode.weight;

                int newDist = cWeight + adjWeight;

                if(newDist < distance[adjVertex]){
                    distance[adjVertex] = newDist;
                    pq.add(new Node(adjVertex, distance[adjVertex]));
                }
            }
        }
    }
}
