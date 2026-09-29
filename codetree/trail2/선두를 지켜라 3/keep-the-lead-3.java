import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];

        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt(); // 속도
            a[i][1] = sc.nextInt(); // 시간

            totalA += a[i][1];
            
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
            totalB += b[i][1];
        }

        int[] posA = new int[totalA];
        int[] posB = new int[totalB];

        int currentTime = 0;
        int currentPos = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0; j<a[i][1]; j++){
                currentPos += a[i][0];
                posA[currentTime+j] = currentPos;
            }
            currentTime += a[i][1];
        }

        currentTime = 0;
        currentPos = 0;
        for (int i = 0; i < m; i++) {
            for(int j=0; j<b[i][1]; j++){
                currentPos += b[i][0];
                posB[currentTime+j] = currentPos;
            }
            currentTime += b[i][1];
        }

        int maxTotal = Math.max(totalA, totalB);
        int count = 0;
        char group = 'N'; // 'N', 'A', 'G', 'B' 
        for(int i=0; i < maxTotal; i++){
            if(posA[i] == posB[i] && group != 'G'){
                count++;
                group = 'G';
            } else if(posA[i] > posB[i]){
                if(group != 'A'){
                    group = 'A';
                    count++;
                }
            }else if(posA[i] < posB[i]){
                if(group != 'B'){
                    group = 'B';
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}