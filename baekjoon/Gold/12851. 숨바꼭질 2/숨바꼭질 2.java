
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int node;
    int count;

    public Node(int node, int count) {
        this.node = node;
        this.count = count;
    }

}

public class Main {
    static int n, k;
    static int counts, minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(minTime + "\n" + counts);
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        int visit[] = new int[100001];

        queue.offer(new Node(n, 0));
        visit[n] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.node == k) {
                if (counts == 0) {
                    minTime = current.count;
                }

                if (minTime == current.count) {
                    counts++;
                }
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = current.node + 1;
                else if (i == 1) next = current.node - 1;
                else next = current.node * 2;

                if (next < 0 || next > 100000) continue;
                if (visit[next] == 0 || visit[next] == current.count + 1) {
                    visit[next] = current.count + 1;
                    queue.offer(new Node(next, current.count + 1));
                }

            }
        }
    }
}
