import java.util.Scanner;

// 직전에 다른 위치에 있다가 다음 번에 같은 위치에 오게 되는 경우의 수
// 시작 같은 지점 -> 횟수에 포함 X
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // A가 움직이는 횟수
        int m = sc.nextInt(); // B가 움직이는 횟수
        
        int MAX_TIME = 2_000_000 + 1; // 움직인 거리의 총 합 
        int[] posA = new int[MAX_TIME];
        int[] posB = new int[MAX_TIME];

        int totalTimeA = 0;
        int currentTime = 0;
        int currentPos = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt(); // 초  
            char d = sc.next().charAt(0); // 방향
            totalTimeA += t;

            for(int j=0; j<t; j++){
                if(d == 'L'){
                    currentPos--;
                }else{
                    currentPos++;
                }
                posA[currentTime] = currentPos;
                currentTime++;
            }
        }
        
        int totalTimeB = 0;
        currentTime = 0;
        currentPos = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            totalTimeB += t;


            for(int j=0; j<t; j++){
                if(d == 'L'){
                    currentPos--;
                }else{
                    currentPos++;
                }
                posB[currentTime] = currentPos;
                currentTime++;
            }
        }

        int count = 0;
        int totalTime = Math.max(totalTimeA, totalTimeB);
        if(totalTimeA > totalTimeB){
            for(int t = totalTimeB; t<totalTime; t++){
                posB[t] = posB[t-1];
            }
        }else{
            for(int t = totalTimeA; t<totalTime; t++){
                posA[t] = posA[t-1];
            }
        }

        for(int i=0; i<totalTime; i++){
            if(i == 0) continue;

            if(posA[i] == posB[i] && posA[i-1] != posB[i-1]){
                count++;
            }
        }

        System.out.println(count);
        
    }
}