import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String rsp) {
        String answer = "";
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '5');
        map.put('2', '0');
        map.put('5', '2');
        for(int i = 0; i < rsp.length(); i++){
            char c = rsp.charAt(i);
            answer += map.get(c);
        }
        return answer;
    }
}