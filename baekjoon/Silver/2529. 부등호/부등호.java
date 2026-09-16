
import java.io.*;
import java.util.*;

// 2529. 부등호
public class Main {

    static int k;

    static boolean[] isUsed;
    static char[] signs;

    static String maxNum = "";
    static  String minNum = "9999999999";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        signs = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        isUsed = new boolean[10];
        makeSets(0, "");

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    private static void makeSets(int depth, String str){
        if(depth > k){
            if (str.compareTo(maxNum) > 0) maxNum = str;
            if (str.compareTo(minNum) < 0) minNum = str;
            return;
        }

        for(int i=0; i<= 9; i++){
            if(isUsed[i]) continue;
            if(depth > 0 && !isValid(str.charAt(depth-1) - '0', i, signs[depth-1])) continue;
            isUsed[i] = true;
            makeSets(depth+1, str + "" + i);
            isUsed[i] = false;
        }
    }


    private static boolean isValid(int prev, int next, char sign) {
        if (sign == '<') return prev < next;
        if (sign == '>') return prev > next;
        return false;
    }
}


