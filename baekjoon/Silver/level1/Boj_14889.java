package baekjoon.silver.level1;

import java.io.*;
import java.util.*;

// 14889. 스타트와 링크
public class Boj_14889 {

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

//        getMinDiff(0,0,n/2, 0 ,0);
        System.out.println(minDiff);
    }


    /**
     * 팀을 구성하는 메소드
     * @param currentMembers 현재까지 팀을 구성한 멤버 수
     * @param totalMembers 한 팀에 해당하는 멤버 수 (n/2)
     * @param start 현재 멤버
     */
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

    /**
     * 능력치의 차이를 구하는 메소드
     * @return 능력치 차
     */
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



///**
// * 팀을 구성하면서 각 팀의 능력치 차이를 구하는 메소드
// * @param currentMember 현재 멤버
// * @param currentMembers 현재까지 팀을 구성한 멤버 수
// * @param totalMembers 한 팀에 해당하는 멤버 수 (n/2)
// * @param power1 team1의 능력치
// * @param power2 team2의 능력치
// */
//private static void getMinDiff(int currentMember, int currentMembers, int totalMembers, int power1, int power2){
//
//    if(currentMembers == totalMembers){
//        minDiff = Math.abs(power1-power2);
//        return;
//    }
//
//    for(int m1=currentMember; m1<totalMembers*2; m1++){
//        members1[m1] = true;
//
//        int newPower1 = power1;
//        for(int m2=0; m2<totalMembers*2; m2++){
//            if(members1[m2]){
//                newPower1 += powers[m1][m2];
//            }
//        }
//        int newPower2 = power2;
//        for(int m2=0; m2<totalMembers*2; m2++){
//            if(!members1[m2]){
//                newPower2 += powers[m1][m2];
//            }
//        }
//
//        getMinDiff(currentMember+1, currentMembers+1, totalMembers, newPower1, newPower2);
//        members1[m1] = false;
//
//    }
//}

