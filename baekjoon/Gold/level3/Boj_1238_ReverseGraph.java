package baekjoon.gold.level3;

import baekjoon.model.Node;

import java.io.*;
import java.util.*;

/*
1238. 파티
아이디어 : 역방향 그래프를 활용
*/
public class Boj_1238_ReverseGraph {
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

        int[] distanceFromX = new int[n+1]; // 목적지 x에서 집으로 돌아오는 최단경로 (x에서 각 정점까지의 거리)
        int[] distanceToX = new int[n+1]; // 모든 마을에서 목적지 x로 가는 최단 경로(각 정점에서 x까지의 거리) -> "역방향 그래프 활용"
        Arrays.fill(distanceFromX, Integer.MAX_VALUE);
        Arrays.fill(distanceToX, Integer.MAX_VALUE);

        dijkstra(adjList, distanceFromX, x); // 목적지 x에서 집으로 돌아오는 최단경로 비용 계산
        dijkstra(reverseAdjList, distanceToX, x); // 모든 정점에서 목적지 x까지 가는 최단경로 비용 계산

        int[] roundDistance = new int[n+1]; // 왕복 최단경로 비용
        for (int i = 1; i < n+1; i++) {
            if(i==x){
                continue;
            }
            roundDistance[i] = distanceFromX[i] + distanceToX[i]; // (목적지-> 집) + (집 -> 목적지)
        }

        int maxDistance = Arrays.stream(roundDistance).max().getAsInt();
        System.out.println(maxDistance);
    }

    /**
     * 다익스트라 알고리즘을 이용하여 시작 정점에서 다른 모든 정점까지의 최단 경로를 구하는 메소드
     * @param adjList 인접 리스트
     * @param distance 최단 경로 비용 배열
     * @param start 시작 정점
     */
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
