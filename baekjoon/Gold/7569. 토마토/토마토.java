import java.io.*;
import java.util.*;

class Coord3D {
    int z; // 높이
    int y; // 세로 latitude / row
    int x; // 가로 longitudes / col
    int days; // 일수

    Coord3D(int z, int y, int x, int days) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.days = days;
    }
}
// 7569. 토마토
public class Main {

    static int m,n,h, greenTomatoes = 0; // 가로, 세로, 높이, 안익은 토마토 개수
    static int[][][] boxes;
    static Queue<Coord3D> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y
        h = Integer.parseInt(st.nextToken()); // z

        boxes = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    boxes[i][j][k] = temp;

                    if(temp == 1){
                        queue.offer(new Coord3D(i,j,k,0));
                    }else if (temp == 0){
                        greenTomatoes++;
                    }

                }
            }
        }


        int minDays = -1;
        if(greenTomatoes == 0){
            minDays = 0;
        }else{
            minDays = countDays();
        }
        System.out.println(minDays);
    }

    // 상하좌우전후
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    private static int countDays(){
        while(!queue.isEmpty()){
            Coord3D redTomatoNode = queue.poll();
            int rtx = redTomatoNode.x;
            int rty = redTomatoNode.y;
            int rtz = redTomatoNode.z;
            int rtDays = redTomatoNode.days;


            for (int i = 0; i < 6; i++) {
                int nx = rtx + dx[i];
                int ny = rty + dy[i];
                int nz = rtz + dz[i];

                // 이동할 위치가 경계 안에 있고 익지않은 토마토라면
                if(isInArea(nx,ny,nz) && boxes[nz][ny][nx] == 0){
                    boxes[nz][ny][nx] = 1;
                    greenTomatoes--;

                    if(greenTomatoes <= 0){
                        return rtDays+1;
                    }
                    queue.offer(new Coord3D(nz,ny,nx, rtDays+1));
                }
            }

        }

        return -1;

    }

    private static boolean isInArea(int x, int y, int z){
        return x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h;
    }
}