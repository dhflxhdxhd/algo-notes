import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int p, count;

    public Node(int p, int count) {
        this.p = p;
        this.count = count;
    }
}


public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] points;
    static boolean isCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken()) - 1;
            int p2 = Integer.parseInt(st.nextToken()) - 1;

            list[p1].add(p2);
            list[p2].add(p1);
        }

        points = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (getCyclenPoint(i, i, i)) break;
            points = new boolean[n];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (!points[i]) result[i] = getDiffDistance(n, i);
        }

        for (int i = 0; i < n; i++) System.out.print(result[i] + " ");
    }

    private static int getDiffDistance(int n, int point) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(new Node(point, 0));
        visited[point] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (points[current.p]) return current.count;

            for (int next : list[current.p]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, current.count + 1));
                }
            }
        }

        return 0;
    }

    private static boolean getCyclenPoint(int prev, int current, int start) {
        points[current] = true;

        for (int i = 0; i < list[current].size(); i++) {
            int next = list[current].get(i);

            if (!points[next]) {
                if (getCyclenPoint(current, next, start)) return true;
            } else if (prev != next && next == start) return true;
        }

        points[current] = false;

        return false;
    }

}
