import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 전염병 옮길 수 있는 횟수
        int P = sc.nextInt(); // 첫 전염병 개발자 번호
        int T = sc.nextInt(); // 악수 기록 수
        int[][] shakes = new int[T][3]; // 악수
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // t
            shakes[i][1] = sc.nextInt(); // 개발자 1
            shakes[i][2] = sc.nextInt(); // 개발자 2
        }

        // 1) shakes[i][0] 순으로 정렬
        Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] developers = new int[N+1][2]; 
        developers[P][0] = 1; // 전염 여부
        developers[P][1] = K; // 감염 횟수
        for(int i=0; i<T; i++){
            int t = shakes[i][0];
            int dev1 =  shakes[i][1];
            int dev2 = shakes[i][2];

            // 둘 다 감염
            if(developers[dev1][1] > 0 && developers[dev2][1] > 0){
                developers[dev1][1]--;
                developers[dev2][1]--;
            }else if(developers[dev1][1] == 0 && developers[dev2][1] > 0){
                if(developers[dev1][0] != 1){
                    developers[dev1][1] = K;
                    developers[dev1][0] = 1;
                }
                developers[dev2][1]--;
            }else if(developers[dev2][1] == 0 && developers[dev1][1] > 0){
                if(developers[dev2][0] != 1){
                    developers[dev2][1] = K;
                    developers[dev2][0] = 1;
                }
                developers[dev1][1]--;
            }
        }

        for(int i=1; i<N+1; i++){
            System.out.print(developers[i][0]);
        }
        
    }
}