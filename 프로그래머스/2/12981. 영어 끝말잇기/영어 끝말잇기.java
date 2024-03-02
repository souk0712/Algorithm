import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        String before = words[0];
        map.put(before, 1);
        for(int i = 1; i < words.length; i++){
            String s = words[i];
            if(before.charAt(before.length() - 1) == s.charAt(0)){
                if(map.containsKey(s)){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                } else{
                    map.put(s, (i % n) + 1);            
                }
            }else{
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            before = s;
        }
        
        return answer;
    }
}