import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = {-1, 0, 0, 1}; // W, S, N, E
        int[] dy = {0, -1, 1, 0};

        int currentX = 0;
        int currentY = 0;
        int dirNum = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            if(direction == 'W'){
                dirNum = 0;
            }else if(direction == 'S'){
                dirNum = 1;
            }else if(direction == 'N'){
                dirNum = 2;
            }else{
                dirNum = 3;
            }


            currentX = currentX + distance*dx[dirNum];
            currentY = currentY + distance*dy[dirNum];
        }

        System.out.print(currentX + " " + currentY);
    }
}