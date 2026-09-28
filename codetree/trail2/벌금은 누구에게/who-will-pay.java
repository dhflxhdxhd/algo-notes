import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] students = new int[n+1]; // 학생 1번 ~ N번 (0번 없음)
        // int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            int penalizedPerson = sc.nextInt();
            students[penalizedPerson]++;

            if(students[penalizedPerson] >= k){
                System.out.println(penalizedPerson);
                return;
            }
        }

        System.out.println(-1);
    }
}