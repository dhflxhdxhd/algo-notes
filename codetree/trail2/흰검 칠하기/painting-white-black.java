import java.util.Scanner;

public class Main {

    static class Tile {
        int black;
        int white;
        String color;

        Tile(int black, int white, String color){
            this.black = black;
            this.white = white;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }

        int sumMid = 100000;
        Tile[] tiles = new Tile[200001];

        // 배열 초기화
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(0, 0, "");
        }

        int startIndex = sumMid;
        for(int i=0; i<n; i++){
            if(dir[i] == 'R'){
                for(int j=startIndex; j<startIndex + x[i]; j++){
                    tiles[j].black++;

                    if(tiles[j].black >= 2 && tiles[j].white >= 2){
                        tiles[j].color = "gray";
                    }         

                    if(!tiles[j].color.equals("gray")){
                        tiles[j].color = "black";
                    }
                }

                startIndex = startIndex + x[i] -1;
            }else{
                for(int j=startIndex; j>startIndex - x[i]; j--){
                    tiles[j].white++;

                    if(tiles[j].black >= 2 && tiles[j].white >= 2){
                        tiles[j].color = "gray";
                    }        

                    if(!tiles[j].color.equals("gray")){
                        tiles[j].color = "white";
                    }
                }
                startIndex = startIndex - x[i] + 1;
            }
        }

        int[] colors = new int[3]; // 흰, 검, 회
        for(int i=0; i<tiles.length; i++){
            if(!tiles[i].color.equals("")){
                if(tiles[i].color.equals("black")){
                    colors[1]++;
                }else if(tiles[i].color.equals("white")){
                    colors[0]++;
                }else{
                    colors[2]++;
                }
            }
        }
        
        System.out.println(colors[0]+" "+colors[1]+" "+colors[2]);
    }
}