import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] dir = new char[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dir[i] = sc.next().charAt(0);
            dist[i] = sc.nextInt();
        }

        int[] dr = {0,1,0, -1};
        int[] dc = {1,0,-1,0};
        int r = 0;
        int c = 0;

        int time = 0;
        for(int i=0; i<n; i++){

            int dirNum = getDirNum(dir[i]);

            for(int j=0; j<dist[i]; j++){
                time++;
                r += dr[dirNum];
                c += dc[dirNum];

                if(r == 0 && c == 0){
                    System.out.print(time);
                    return;
                }
            }
        }

        System.out.print(-1);
    }

    public static int getDirNum(char d){
        if(d == 'W'){
            return 2;
        }else if(d == 'S'){
            return 1;
        }else if(d == 'N'){
            return 3;
        }else if(d == 'E'){
            return 0;
        }

        return -1;
    }

}