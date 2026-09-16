package softeer.level2;

import java.io.*;
import java.util.*;
public class Softeer_7628 {
    static int[] nanro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfHouses = Integer.parseInt(br.readLine());

        nanro = new int[numberOfHouses];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfHouses; i++) {
            nanro[i] = Integer.parseInt(st.nextToken());
        }

        int maxHouses = 0;
        Arrays.sort(nanro);

        for (int i = 2; i <= nanro[numberOfHouses-1]; i++) {
            int count = countUsableHouses(i);
            maxHouses = Math.max(maxHouses, count);
        }

        System.out.println(maxHouses);
    }

    private static int countUsableHouses(int target) {
        int houseCount = 0;

        for (int i = 0; i < nanro.length; i++) {
            if (nanro[i] % target == 0) {
                houseCount++;
            }
        }

        return houseCount;
    }
}
