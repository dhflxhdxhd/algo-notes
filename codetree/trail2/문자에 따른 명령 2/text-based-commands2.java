import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] dx = {1, 0, -1, 0}; // 동남서북
        int[] dy = {0, -1, 0, 1};

        int currentX = 0;
        int currentY = 0;
        int dirNum = 3; // 북
        for(int i=0; i<s.length(); i++){
            char order = s.charAt(i);

            if(order == 'L'){
                dirNum = (dirNum - 1 + 4) % 4;
            }else if(order == 'R'){
                dirNum = (dirNum + 1) % 4;
            }else{
                currentX += dx[dirNum];
                currentY += dy[dirNum];
            }
        }

        System.out.print(currentX + " " + currentY);
    }


}