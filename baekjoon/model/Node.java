package baekjoon.model;

// Node 클래스: 정점과 해당 정점까지의 가중치를 나타냄
public class  Node  implements Comparable<Node>{
    public int vertex; // 정점
    public  int weight; // 간선(가중치)

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
