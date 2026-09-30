import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int dirNum = 3;
        int r = 0;
        int c = 0;
        int time = 0;

        for(int i=0; i<commands.length(); i++){
            char cmd = commands.charAt(i);
            if(cmd == 'L'){
                dirNum = (dirNum - 1 + 4 ) % 4;
                time++;
            }else if(cmd == 'R'){
                dirNum = (dirNum + 1 ) % 4;
                time++;
            }else{
                r += dr[dirNum];
                c += dc[dirNum];
                time++;
                if(r == 0 && c == 0){
                    System.out.print(time);
                    return;
                }
            }
        }

        System.out.print(-1);

    }
}