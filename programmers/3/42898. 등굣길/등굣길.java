import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        
        map[1][1] = 1;
        for(int i=0; i<puddles.length; i++){
            int tempCol = puddles[i][0];
            int tempRow = puddles[i][1];
            
            map[tempRow][tempCol] = -1;
        }
       
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j ==1){
                    continue;
                }
                
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                
                map[i][j] = (map[i-1][j] + map[i][j-1]) %1000000007;
            }
            
            answer = map[n][m];
        }
      
        
        return answer;
    }
}