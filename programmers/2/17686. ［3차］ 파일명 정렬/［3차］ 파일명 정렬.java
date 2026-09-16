import java.io.*;
import java.util.*;
import java.util.regex.*;

class File implements Comparable<File>{
    String origin;
    String head;
    String number;
    String tail;
    int idx;
    
    public File(String origin, String head, String number, String tail, int idx){
        this.origin = origin;
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(File f) {
        int headCompare = this.head.toLowerCase().compareTo(f.head.toLowerCase());
        if (headCompare != 0) {
            return headCompare;
        }

        int numberCompare = Integer.parseInt(this.number) - Integer.parseInt(f.number);
        if (numberCompare != 0) {
            return numberCompare;
        }

        return this.idx - f.idx;
    }
}

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-zA-Z\\-]+)([0-9]+)(.*)?");
        
        // List<File> fileList = new ArrayList<>();
        // int idx = 0;
//         for(String file : files){
//             Matcher matcher = pattern.matcher(file);
            
//             if(matcher.matches()){
//                 String head = matcher.group(1); // head
//                 String number = matcher.group(2); // number
//                 String tail = matcher.group(3) == null ? "" : matcher.group(3); // tail
//                 fileList.add(new File(file, head, number, tail, idx++));
//             }
//         }
        
        // Collections.sort(fileList);
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String head1 = o1.split("[0-9]+")[0];                
                String head2 = o2.split("[0-9]+")[0];
                
                int headCompare = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(headCompare != 0){
                    return headCompare;
                }
                
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher1 = pattern.matcher(o1);
                Matcher matcher2 = pattern.matcher(o2);
                
                int number1 = 0;
                int number2 = 0;
                if(matcher1.find()){
                    number1 = Integer.parseInt(matcher1.group());
                }
                
                if(matcher2.find()){
                    number2 = Integer.parseInt(matcher2.group());
                }
                

                return Integer.compare(number1, number2);
            }
        });
            
            
            
            
        // String[] answer = new String[fileList.size()];
        // idx = 0;
        // for (File file : fileList) {
        //     answer[idx++] = file.origin;
        // }
        
        return files;
    }
}