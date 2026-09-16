package softeer.level2;

import java.io.*;
import java.util.*;
public class Softeer_7374 {
    static int N = 3;
    static int[][] map = new int[N][N];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minResult = Math.min(minResult, checkRow(i));
            if(minResult == 0){
                break;
            }

            minResult = Math.min(minResult, checkCol(i));
            if(minResult == 0){
                break;
            }
        }

        System.out.println(minResult);
    }

    /**
     * 가로
     */

    static HashSet<Integer> sets = new HashSet<>();
    private static int checkRow(int Idx){
        sets.clear();
        int cell1 = map[Idx][0];
        int cell2 = map[Idx][1];
        int cell3 = map[Idx][2];

        sets.add(cell1);
        sets.add(cell2);
        sets.add(cell3);

        int size = sets.size();
        if(size == 1){
            return 0;
        }else if(size == 2){
            int max = Collections.max(sets);
            int min = Collections.min(sets);
            return max-min;
        }else if (size == 3){
            int sum = 0;
            for (int num : sets){
                sum += num;
            }
            return (int) Math.ceil(sum/size);
        }

        return -1;
    }

    private static int checkCol(int Idx){
        sets.clear();
        int cell1 = map[0][Idx];
        int cell2 = map[1][Idx];
        int cell3 = map[2][Idx];

        sets.add(cell1);
        sets.add(cell2);
        sets.add(cell3);

        int size = sets.size();
        if(size == 1){
            return 0;
        }else if(size == 2){
            return 2;
        }else if (size == 3){
            int maxValue = Collections.max(sets);
            int minValue = Collections.min(sets);

            return maxValue - minValue;
        }

        return -1;
    }
}
