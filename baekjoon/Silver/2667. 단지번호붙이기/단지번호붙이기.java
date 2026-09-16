import java.io.*;
import java.util.*;

class Coord{
    int y; // 세로 latitude
    int x; // 가로 longitude

    public Coord(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
// 2667. 단지번호 붙이기
public class Main {

    static int n;
    static int[][] map;
    static List<Integer> houses = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int number = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    getTown(i,j, number++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number-2);
        sb.append("\n");

        Collections.sort(houses);
        for (int h = 0; h < houses.size(); h++) {
            sb.append(houses.get(h));
            sb.append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }

    // 상우하좌
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    private static void getTown(int y, int x, int number){
        Queue<Coord> queue = new LinkedList<Coord>();
        queue.offer(new Coord(y,x));
        map[y][x] = number;
        int count = 1;

        while (!queue.isEmpty()){
            Coord coord = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = coord.x + dx[i];
                int ny = coord.y + dy[i];

                if(isInArea(nx,ny)  && map[ny][nx] == 1){
                    map[ny][nx] = number;
                    count++;
                    queue.offer(new Coord(ny, nx));
                }
            }
        }

        houses.add(count);
    }


    private static boolean isInArea(int x, int y){
        return x >= 0 &&  x < n && y >= 0 && y < n;
    }
}