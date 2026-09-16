package baekjoon.gold.level2;

import baekjoon.model.Node;

import java.io.*;
import java.util.*;

// 9370. 미확인 도착지
public class Boj_9370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 교차로(정점) 개수
            int E = Integer.parseInt(st.nextToken()); // 도로(간선) 개수
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보의 개수

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<List<Node>> adjList = new ArrayList<>(V+1);
            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // a와 b 사이 가중치 d (양방향 도로)
                adjList.get(a).add(new Node(b,d));
                adjList.get(b).add(new Node(a,d));
            }

            int[] destOptions = new int[t]; // 목적지 후보 담는 배열
            for (int i = 0; i < t; i++) {
                destOptions[i] = Integer.parseInt(br.readLine());
            }

            int[] sDist = new int[V+1]; // 정점 s를 시작으로 하는 최단 경로 비용 담는 배열
            int[] gDist = new int[V+1]; // 정점 g를 시작으로 하는 최단 경로 비용 담는 배열
            int[] hDist = new int[V+1]; // 정점 h를 시작으로 하는 최단 경로 비용 담는 배열
            Arrays.fill(sDist, Integer.MAX_VALUE);
            Arrays.fill(gDist, Integer.MAX_VALUE);
            Arrays.fill(hDist, Integer.MAX_VALUE);

            dijkstra(adjList, sDist, start);
            dijkstra(adjList, gDist, g);
            dijkstra(adjList, hDist, h);

            List<Integer> dest = new LinkedList<>();

            // 목적지 후보만큼 체크
            for (int i = 0; i < t; i++) {
                int targetDest = destOptions[i];

                // 방법 1
                int gToh = sDist[g] + gDist[h] + hDist[targetDest]; // g에서 h를 거치는 최단 경로 비용 (s->g->h->targetDest)
                int hTog = sDist[h] + hDist[g] + gDist[targetDest]; // h에서 g를 거치는 최단 경로 비용 (s->h->g->targetDest)

                // "g에서 h를 거치는 최단 경로 비용"이 "s에서 목적지 후보까지 거치는 최단 경로 비용"이 같다면 후보 가능
                if (gToh == sDist[targetDest] || hTog == sDist[targetDest]) {
                    dest.add(targetDest);
                }
            }

            Collections.sort(dest); // 오름차순 정렬

            for (int d = 0; d < dest.size(); d++) {
                sb.append(dest.get(d));
                if (d < dest.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
