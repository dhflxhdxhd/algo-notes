import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> dic = new HashMap<>();
        for(int i=1; i<= 26; i++){
            dic.put(String.valueOf((char)(i+64)), i);
        }
        
        int lastIdx = 26;
        int currentIdx = 0; 
    
        List<Integer> outputNumbers = new ArrayList<>();
        while(currentIdx < msg.length()){    
            String str = "";
            int nextIdx = currentIdx;
            
            while(nextIdx < msg.length() && dic.containsKey(str+msg.charAt(nextIdx))){
                str += msg.charAt(nextIdx);
                nextIdx++;
            }
            
            outputNumbers.add(dic.get(str));
            
            if (nextIdx < msg.length()) {
                dic.put(str + msg.charAt(nextIdx), ++lastIdx);
            }
            
            currentIdx = nextIdx;
        }
       
        int[] answer = new int[outputNumbers.size()];
        int index = 0;
        for (int num : outputNumbers) {
            answer[index++] = num;
        }
        return answer;
    }
}