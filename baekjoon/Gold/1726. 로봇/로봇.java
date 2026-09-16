
import java.io.*;
import java.util.*;

class RobotNode{
    int row;
    int col;
    int dir;
    int count;
    public RobotNode(int row, int col, int dir, int count) {
        this.row = row;
        this.col = col;
        this.dir = dir;
        this.count = count;
    }
}
public class Main {

    static int m,n = 0; // 행, 열 개수
    static int[][] map;
    static boolean[][][] visited;
    static RobotNode startSpot;
    static RobotNode endSpot;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 세로
        n = Integer.parseInt(st.nextToken()); // 가로

        map = new int[m][n];
        visited = new boolean[m][n][4]; // 동서남북에서 (m,n)의 위치에 갈 때 최소 횟수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r,d,c;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        d = Integer.parseInt(st.nextToken())-1;
        startSpot = new RobotNode(r,c,d,0); // 시작지점

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        d = Integer.parseInt(st.nextToken())-1;
        endSpot = new RobotNode(r,c,d, 0); // 도착지점

        int minMovement = trackRobotMovements();
        System.out.println(minMovement);
    }

    // 동서남북
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    private static int trackRobotMovements(){
        Queue<RobotNode> queue = new ArrayDeque<>();
        queue.offer(startSpot);
        visited[startSpot.row][startSpot.col][startSpot.dir] = true; // 시작지점

        while(!queue.isEmpty()){
            RobotNode currentNode = queue.poll();
            int currentRow = currentNode.row;
            int currentCol = currentNode.col;
            int currentDir = currentNode.dir;
            int currentCount = currentNode.count;
            // 도착지점이라면
            if(currentRow == endSpot.row && currentCol == endSpot.col && currentDir == endSpot.dir){
                return currentCount;
            }
            // 명령 1
            for (int k = 1; k <= 3; k++) {
                int nr = currentRow + dr[currentDir]*k;
                int nc = currentCol + dc[currentDir]*k;
                
                if(isInArea(nr, nc) && map[nr][nc] == 0){
                    if(visited[nr][nc][currentDir]) continue;
                    queue.offer(new RobotNode(nr,nc,currentDir, currentCount+1));
                    visited[nr][nc][currentDir] = true;
                }else{
                    break;
                }
            }


            // 명령 2
            int left= 0, right = 0;
            switch (currentDir){
                case 0: left =  3; right = 2; break;  // 동
                case 1: left =  2; right = 3; break;  // 서
                case 2: left =  0; right = 1; break;  // 남
                case 3: left =  1; right = 0; break;  // 북
            }

            if(!visited[currentRow][currentCol][left]){
                queue.offer(new RobotNode(currentRow, currentCol, left, currentCount+1));
                visited[currentRow][currentCol][left] = true;
            }

            if(!visited[currentRow][currentCol][right]) {
                queue.offer(new RobotNode(currentRow, currentCol, right, currentCount + 1));
                visited[currentRow][currentCol][right] = true;
            }
        }

        return -1;
    }

    private static boolean isInArea(int row, int col){
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
