import java.io.*;
import java.util.*;

// 2110. 공유기 설치
public class Main {

    static int n,c; // 집의 개수, 공유기의 개수
    static int[] houses;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int minDist = getMinDistance();
        System.out.println(minDist - 1);
    }

    private static int getMinDistance(){
        int left = 1;
        int right = houses[n-1] - houses[0] ;

        while(left <= right){
            int mid = left+(right-left) / 2; // 중간값

            // 공유기 개수보다 작으면 거리를 줄여야 함.
            if(countRouters(mid) < c) {
                right = mid - 1;
            }else{
                // 공유기 개수보다 크거나 같으면 거리를 늘려봄.
                left = mid + 1;
            }
        }
        return left;
    }

    private static int countRouters(int dist){
        int count = 1;
        int currentLocation = houses[0];

        for (int i = 1; i < n; i++) {
            int tempLocation = houses[i];

            if(tempLocation - currentLocation >= dist){
                count++;
                currentLocation = tempLocation;
            }
        }

        return count;
    }
}
