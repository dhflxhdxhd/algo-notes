package basic.graph.shortestpath;

import java.util.*;

/*
최단 경로 알고리즘 - 다익스트라 알고리즘
시작 정점에서 다른 모든 정점으로의 최단 경로를 구하는 알고리즘
음의 간선이 없을 때 정상적으로 동작
 */
public class Dijkstra_PQueue {
    public static void main(String[] args) {
        int v = 5; // 정점의 개수
        List<List<Node>> adjList = new ArrayList<>(v + 1);

        // 인접리스트 초기화
        for (int i = 0; i <= v ; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(new Node(2,10));
        adjList.get(1).add(new Node(3,3));
        adjList.get(2).add(new Node(3,1));
        adjList.get(2).add(new Node(4,2));
        adjList.get(3).add(new Node(2,4));
        adjList.get(3).add(new Node(4,8));
        adjList.get(3).add(new Node(5,2));
        adjList.get(4).add(new Node(5,7));
        adjList.get(5).add(new Node(4,9));

        int start = 1; // 시작 정점
        int[] distance = new int[v+1]; // 각 정점까지의 최단 경로 비용
        int[] parent = new int[v+1]; // 각 정점까지 도달하기 위해 방문한 이전 정점 기록

        Arrays.fill(distance, Integer.MAX_VALUE); // 거리 배열을 무한대로 초기화
        Arrays.fill(parent, -1); // 부모 배열을 -1로 초기화
//        for (int i = 1; i <= v; i++) {
//            System.out.println("정점 : " + i);
////            System.out.println("List " + adjList.get(i));
//            List<Node> nodes = adjList.get(i);
//            for (Node node : nodes){
//                System.out.println(node.toString());
//            }
//            System.out.println(" ");
//        }

        dijkstra(adjList, distance,parent, start);
        for (int i = 1; i <= v; i++) {
            System.out.println( i + "\t"+ (distance[i]==Integer.MAX_VALUE ? "/" : distance[i]));
            System.out.println("path : " + getPath(parent, i)); // 경로 출력
        }

    }

    /**
     * 다익스트라 알고리즘을 이용하여 시작 정점에서 다른 모든 정점까지의 최단 경로를 구하는 메소드
     * @param adjList 인접 리스트
     * @param distance 최단 경로 비용 배열
     * @param parent 각 정점까지 도달하기 위해 방문한 이전 정점 배열
     * @param start 시작 정점
     */
    public static void dijkstra(List<List<Node>> adjList, int[] distance, int[] parent, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int cVertex = current.vertex;
            int cWeight = current.weight;

            // 현재 노드에서 인접한 노드 확인
            for (Node temp : adjList.get(cVertex)){
                int newDist = cWeight + temp.weight;

                // 더 짧은 경로가 발견된 경우
                if(newDist < distance[temp.vertex]){
                    distance[temp.vertex] = newDist;
                    parent[temp.vertex] = cVertex; // 경로 기록
                    pq.add(new Node(temp.vertex, newDist));
                }
            }
        }
    }

    /**
     * target에 최단경로로 도달하기까지의 최단 경로를 반환하는 메소드
     * @param parent 각 정점까지 도달하기 위해 방문한 이전 정점 배열
     * @param target 최단 경로를 알고 싶은 정점
     * @return 최단 경로를 나타내는 리스트
     */
    private static List<Integer>  getPath(int[] parent, int target){
        List<Integer> path = new LinkedList<>();

        for (int t = target; t != -1 ; t = parent[t]) {
            path.add(t);
        }

        Collections.reverse(path); // 경로를 시작 정점부터 도착 정점까지 순서대로 정렬
        return path;
    }
}
