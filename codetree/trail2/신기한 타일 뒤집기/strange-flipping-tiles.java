import java.util.Scanner;
public class Main {
    
    static class Tile{
        int black;
        int white;
        char color; // 'w', 'b', 'n'

        Tile(int black, int white, char color){
            this.black = black;
            this.white = white;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int MAX_TILES = 200001;
    
        Tile[] tiles = new Tile[MAX_TILES];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(0,0,'n');
        }

        int currentIndex = 100000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'R'){
                for(int j=currentIndex; j<currentIndex + x; j++){
                    tiles[j].black++;
                    tiles[j].color = 'b';
                }

                currentIndex = currentIndex + x - 1;
            }else{
                for(int j=currentIndex; j>currentIndex - x; j--){
                    tiles[j].white++;
                    tiles[j].color = 'w';
                }

                currentIndex = currentIndex - x + 1;
            }
        }

        int sumW = 0;
        int sumB = 0;
        for (int i = 0; i < tiles.length; i++) {
            if(tiles[i].color == 'w'){
                sumW++;
            }else if(tiles[i].color == 'b'){
                sumB++;
            }
        }

        System.out.println(sumW + " " + sumB);

    }
}