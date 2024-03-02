import java.io.*;
import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> com = new HashMap<>();
        for(String s: completion){
            if(com.containsKey(s)){
                com.put(s, com.get(s) + 1);
            }else{
                com.put(s, 1);
            }
        }
        
        for(int i = 0; i < participant.length; i++){
            String str = participant[i];
            if(!com.containsKey(str)){
                answer = str;
                break;
            }else{
                int cnt = com.get(str);
                if(cnt > 0){
                    com.put(str, cnt - 1);
                }else{
                    answer = str;
                    break;
                }
            }
        }
        
        return answer;
    }
}