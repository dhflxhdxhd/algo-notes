import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int totalTime = 0; // A,B의 총 이동시간
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt(); // v (속도)
            A[i][1] = sc.nextInt(); // t  (지속시간)
            totalTime += A[i][1];
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }

        int[] posA = new int[totalTime + 1]; // 매 시간마다의 위치
        int[] posB = new int[totalTime + 1];

        int currentTime = 0;
        int currentPos = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0; j<A[i][1]; j++){
                currentTime++;
                currentPos += A[i][0];

                posA[currentTime] = currentPos;
            }
        }

        currentTime = 0;
        currentPos = 0;
        for (int i = 0; i < m; i++) {
            
            for(int j=0; j<B[i][1]; j++){
                currentTime++;
                currentPos += B[i][0];

                posB[currentTime] = currentPos;
            }
        }

        char lead = 'N';
        int count = 0;
        for(int i=0; i<totalTime; i++){
            if (posA[i] == posB[i]) {
                continue;
            }

            if(lead == 'N'){
                if(posA[i] > posB[i]){
                    lead = 'A';
                    // count++;
                }else if(posA[i] < posB[i]){
                    lead = 'B';
                    // count++;
                }
            }else if(lead == 'A'){
                if(posA[i] < posB[i]){
                    lead = 'B';
                    count++;
                }
            }else{
                if(posA[i] > posB[i]){
                    lead = 'A';
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}