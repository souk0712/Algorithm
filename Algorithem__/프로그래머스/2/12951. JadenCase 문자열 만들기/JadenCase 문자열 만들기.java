import java.io.*;
import java.util.*;

class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s.toLowerCase());
        char temp = Character.toUpperCase(answer.charAt(0));
        answer.deleteCharAt(0);
        answer.insert(0, temp);
        
        for(int i = 0; i < answer.length() - 1; i++){
            char cur = answer.charAt(i);
            char next = answer.charAt(i + 1);
        
            if(cur == ' ' && next != ' '){
                temp = Character.toUpperCase(next);
                answer.deleteCharAt(i + 1);
                answer.insert(i + 1 , temp);
            }
        }
        return answer.toString();
    }
}