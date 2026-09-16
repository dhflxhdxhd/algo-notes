import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.*;

class ThreeNode {
    int a;
    int b;
    int c;

    public ThreeNode(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
// 12886. 돌 그룹
public class Main {

    static int check = 0;
    static boolean[][] visited = new boolean[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if((a+b+c)%3 != 0){
            System.out.println(check);
        }else{
            visited[0][0] = true;
            bfs(a,b,c);
            System.out.println(check);
        }
    }

    private static void bfs(int a, int b, int c){
        Queue<ThreeNode> queue = new LinkedList<>();
        queue.offer(new ThreeNode(a,b,c));
        visited[a][b] = true;
        visited[b][a] = true;

        while(!queue.isEmpty()){
            ThreeNode node = queue.poll();
            int nodeA = node.a;
            int nodeB = node.b;
            int nodeC = node.c;

            if(nodeA == nodeB && nodeB == nodeC){
                check = 1;
                return;
            }

            if(nodeA != nodeB){
                int tempA = nodeA > nodeB ? nodeA - nodeB : nodeA*2;
                int tempB = nodeA > nodeB ? nodeB*2 : nodeB - nodeA;

                if(!visited[tempA][tempB]){
                    queue.offer(new ThreeNode(tempA, tempB, nodeC));
                    visited[tempA][tempB] = true;
                    visited[tempB][tempA] = true;
                }
            }

            if(nodeB != nodeC){
                int tempB = nodeB > nodeC ? nodeB - nodeC : nodeB*2;
                int tempC = nodeB > nodeC ? nodeC*2 : nodeC - nodeB;

                if(!visited[tempB][tempC]){
                    queue.offer(new ThreeNode(nodeA, tempB, tempC));
                    visited[tempC][tempB] = true;
                    visited[tempB][tempC] = true;
                }
            }

            if(nodeC != nodeA){
                int tempC = nodeC > nodeA ? nodeC - nodeA : nodeC*2;
                int tempA = nodeC > nodeA ? nodeA*2 : nodeA - nodeC;


                if(!visited[tempA][tempC]){
                    queue.offer(new ThreeNode(tempA, nodeB, tempC));
                    visited[tempC][tempA] = true;
                    visited[tempA][tempC] = true;
                }
            }
        }

    }
}