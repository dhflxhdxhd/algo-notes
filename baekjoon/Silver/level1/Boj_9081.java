//package baekjoon.silver.level1;
//
//import java.io.*;
//import java.util.*;
//
//// 9081. 단어 맞추기
//public class Boj_9081 {
//
//    static String result = "";
//    static Boolean check = false;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<t; i++){
//            String target = br.readLine();
//            char[] strArr = target.toCharArray();
//            Arrays.sort(strArr);
//            check = false;
//            result = "";
//            boolean[] visited = new boolean[strArr.length];
//
//            getWords(strArr, "", target,  visited);
//            System.out.println(result);
//        }
//    }
//
//    private static void getWords(char[] strArr, String currentWord, String target,  boolean[] visited){
//        if(currentWord.length() == strArr.length){
////            System.out.println(currentWord);
//
//            if (currentWord.equals(target)) {
//                check = true;
//            } else if (check) {
//                result = currentWord;
//                return;
//            }
//            return;
//        }
//        for(int i=0; i< strArr.length; i++){
//            if(visited[i]) continue;
//            visited[i] = true;
//            getWords(strArr, currentWord + strArr[i] , target, visited);
//            visited[i] = false;
//        }
//    }
//
//}
