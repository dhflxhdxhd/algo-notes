import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int MAX_T = 1000*1000; 
        int[] posA = new int[MAX_T]; // 매 초에 서있는 위치
        int[] posB = new int[MAX_T];

        int currentDir = 0;
        int currentTime = 0;
        for(int i=0; i<n; i++){
            char dir = sc.next().charAt(0);
            int time = sc.nextInt();
            for(int t=0; t<time; t++){
                if(dir == 'R'){
                    currentDir++;
                }else{
                    currentDir--;
                }
                posA[currentTime] = currentDir;
                currentTime++;
            }
        }

        currentDir = 0;
        currentTime = 0;
        for(int i=0; i<m; i++){
            char dir = sc.next().charAt(0);
            int time = sc.nextInt();
            for(int t=0; t< time; t++){
                if(dir == 'R'){
                    currentDir++;
                }else{
                    currentDir--;
                }
                posB[currentTime] = currentDir;
                currentTime++;

            }

        }

        for(int i=0; i<currentTime; i++){
            if(posA[i] == posB[i]){
                System.out.println(i + 1);
                return;
            }
        }
        
        System.out.println(-1);

    }
}