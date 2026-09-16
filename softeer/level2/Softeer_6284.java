package softeer.level2;

import java.io.*;
import java.util.*;

// 6284. 바이러스
public class Softeer_6284 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int count = 1;
        if(n == 1){
            System.out.println(k);
        }else{
            while (count++ <= n){
                k *= p;
            }
            System.out.println(k);
        }
    }
}
