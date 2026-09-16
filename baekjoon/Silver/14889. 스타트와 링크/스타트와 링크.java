import java.io.*;
import java.util.*;

// 14889. 스타트와 링크
public class Main {

    static boolean[] members1; // team1에 속할 경우 true
    static int[][] powers;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        powers = new int[n][n];
        members1 = new boolean[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                powers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getTeam(0,n/2, 0);

        System.out.println(minDiff);
    }


    private static void getTeam(int currentMembers, int totalMembers, int start){
        if(currentMembers == totalMembers){
            minDiff = Math.min(minDiff, calPowerDiff());
            return;
        }

        for(int i=start; i< totalMembers*2; i++){
            members1[i] = true;
            getTeam(currentMembers+1, totalMembers, i+1);
            members1[i] = false;
        }
    }

    private static int calPowerDiff(){
        int powerDiff = 0;

        int power1 = 0;
        int power2 = 0;

        for(int m1=0; m1<members1.length; m1++){
            for(int m2=0; m2<members1.length; m2++){
                if(m1 == m2) continue;

                if(members1[m1] && members1[m2]) power1 += powers[m1][m2];
                if(!members1[m1] && !members1[m2]) power2 += powers[m1][m2];
            }
        }

        powerDiff = Math.abs(power1-power2);

        return powerDiff;
    }
}