import java.io.*;
import java.util.*;

// 2644. 촌수계산
public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수


        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        int m = Integer.parseInt(br.readLine()); // 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        calculateKinship(p1,p2,0);
        System.out.println(kinship);
    }

    static int kinship = -1;
    private static void calculateKinship(int start, int end, int distance){
        if(start == end){
            kinship = distance;
            return;
        }

        visited[start] = true;
        for (int neighbor : graph.get(start)){
            if(!visited[neighbor]){
                calculateKinship(neighbor, end, distance+1);
            }
        }
    }
}