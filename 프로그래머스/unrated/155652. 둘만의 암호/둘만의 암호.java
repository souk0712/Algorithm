import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] alpha = new boolean[26];
        
        for(int i = 0; i < skip.length(); i++){
            char c = skip.charAt(i);
            alpha[c % 'a'] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            
            while(cnt < index){
                if(c == 'z') c = 'a';
                else c += 1;
                
                if(!alpha[c % 'a']){
                    cnt++;
                }
            }
            
            answer.append(c);
        }
        
        return answer.toString();
    }
}