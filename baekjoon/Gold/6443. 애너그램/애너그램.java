
import java.io.*;
import java.util.*;

// 6443. 애너그램
public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        char[] words = null;
        boolean[] usedAlpha = null;
        for (int i = 0; i < t; i++) {
            words = br.readLine().toCharArray();
            Arrays.sort(words); // 오름차순 정렬

            usedAlpha = new boolean[26]; // 중복 영단어 사용 체크

            getAnagrams(words, usedAlpha, "");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1).toString());
    }

    private static void getAnagrams(char[] words, boolean[] usedAlpha,  String str){
        if(str.length() == words.length){
            sb.append(str).append("\n");
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!usedAlpha[i]){
                if(i>0 && words[i-1] == words[i] && !usedAlpha[i-1]) continue;
                usedAlpha[i] = true;
                getAnagrams(words, usedAlpha,  str+words[i]);
                usedAlpha[i] = false;
            }
        }
    }
}

