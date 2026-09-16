package baekjoon.gold.level3;

import baekjoon.model.Node;

import java.io.*;
import java.util.*;

// 1238. 파티
public class Boj_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수 (정점)
        int m = Integer.parseInt(st.nextToken()); // 단방향 도로 개수 (간선)
        int x = Integer.parseInt(st.nextToken()); // 목적지

        List<List<Node>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList.get(startNode).add(new Node(endNode, weight));
        }

        int[][] distance = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // 모든 마을이 모든 마을을 가는 최단경로 비용 계산
        for (int i = 1; i < n+1 ; i++) {
            dijkstra(adjList, distance[i], i);
        }

        int[] roundDistance = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            // 목적지 마을이라면
            if(i == x){
                roundDistance[i] = 0;
            }else{
                roundDistance[i] = distance[i][x] + distance[x][i]; // x번 마을까지 가는 최소비용 + 다시 집으로 돌아오는 최소비용
            }
        }

        int maxTime = Arrays.stream(roundDistance).max().getAsInt();
        System.out.println(maxTime);
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
