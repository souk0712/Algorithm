import java.io.*;
import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] sp = my_string.split(" ");
        int answer = Integer.parseInt(sp[0]);
        for(int i = 1; i < sp.length; i++){
            String s = sp[i];
            if(s.equals("+")){
                i++;
                int next = Integer.parseInt(sp[i]);
                answer += next;
            }else if(s.equals("-")){
                i++;
                int next = Integer.parseInt(sp[i]);
                answer -= next;
            }
        }
        return answer;
    }
}