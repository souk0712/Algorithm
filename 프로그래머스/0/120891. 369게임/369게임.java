import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int order) {
        int answer = 0;
        String orderString = String.valueOf(order);
        for(int i = 0; i < orderString.length(); i++){
            char c = orderString.charAt(i);
            if(c == '3' || c == '6' || c == '9'){
                answer++;
            }
        }
        return answer;
    }
}