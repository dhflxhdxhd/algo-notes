import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int len = s.length()/2;
        

        // 압축할 단위
        while(len >= 1){
            int start = 0;
            StringBuilder compressed = new StringBuilder();
            String part = s.substring(start,start + len);
            int count = 0;
            for(int i=start; i<= s.length(); i+=len){
                int endIdx = Math.min(i + len, s.length());
                String newPart = s.substring(i, endIdx);
                
                if(newPart.equals(part)){
                    count++;
                }else{
                    if(count > 1){
                        compressed.append(count);
                    }
                    compressed.append(part);

                    part = newPart;
                    count = 1;
                }
            }
            
            if(count > 1){
                compressed.append(count);
            }
            compressed.append(part);
    
            answer = Math.min(answer, compressed.length());
            len--;
        }
        
        return answer;
    }
}