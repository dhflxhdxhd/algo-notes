import java.io.*;
import java.util.*;

class Node {
    int row; 
    int col;
     
    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    static int mapRow, mapCol;
    static Map<Integer, Integer> oilInfo = new HashMap<>();
    public int solution(int[][] land) {
        
        mapRow = land.length;
        mapCol = land[0].length;
        
        int number = 2;
        for(int r=0; r<mapRow; r++){
            for(int c=0; c<mapCol; c++){
                if(land[r][c] == 1){
                    countOil(land, r,c, number++);
                }
            }
        }
        
        int maxOil = 0;
        for(int c=0; c<mapCol; c++){
            Set<Integer> oilNumbers = new HashSet<>();
            for(int r=0; r<mapRow; r++){
                if(land[r][c] > 1){
                    oilNumbers.add(land[r][c]);
                }
            }
            
            int sum = 0;
            for(int oilNumber : oilNumbers){
                sum += oilInfo.get(oilNumber);
            }
            maxOil = Math.max(maxOil, sum);
        }
        
       
        return maxOil;
    }

    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static void countOil(int[][] land, int row, int col, int number){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(row, col));
        land[row][col] = number;
        int count = 1;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int d=0; d<4; d++){
                int nr = current.row + dr[d];
                int nc = current.col + dc[d];
                
                if(isInArea(nr, nc) && land[nr][nc] == 1){
                    land[nr][nc] = number;
                    count++;
                    queue.offer(new Node(nr, nc));
                }
            }
        }
    
        oilInfo.put(number, count);
        return;
    }
    
    private static boolean isInArea(int row, int col){
        return row >= 0 && row < mapRow && col >= 0 && col < mapCol;
    }
}