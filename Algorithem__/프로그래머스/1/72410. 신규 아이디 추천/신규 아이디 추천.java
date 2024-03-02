import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String new_id) {
        // 1 2 3
        StringBuilder answer = new StringBuilder(new_id.toLowerCase().replaceAll("[^0-9a-z_.-]","")
                                                 .replaceAll("[.]{2,}","."));
        
        // 4
        if(answer.length() > 0 && answer.charAt(0) == '.'){
            answer.deleteCharAt(0);
        }
        
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.'){
            answer.deleteCharAt(answer.length() - 1);
        }
        
        // 5
        if(answer.length() == 0){
            answer.append('a');
        }

        // 6
        if(answer.length() >= 16){
            answer = new StringBuilder(answer.substring(0, 15));
            if(answer.charAt(answer.length() - 1) == '.'){
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        
        // 7
        if(answer.length() <= 2){
            char c = answer.charAt(answer.length() - 1);
            while(answer.length() != 3){
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}