import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];

        int total = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<ability.length - 2; i++){
            for(int j=i+1; j<ability.length-1; j++){
                for(int k=j+1; k<ability.length; k++){
                    int teamA = ability[i] + ability[j] + ability[k];
                    int teamB = total - teamA;
                    int diff = Math.abs(teamA - teamB);
                    minDiff = Math.min(diff, minDiff);
                }
            }
        }


        System.out.println(minDiff);
    }
}