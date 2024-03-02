import java.io.*;
import java.util.*;

class Solution {

    public int solution(String A, String B) {
        int answer = 0;
        while(!A.equals(B)){
            A = spreadWord(A);
            answer++;
            if(A.length() == answer)
                return -1;
        }
        return answer;
    }
    
    public static String spreadWord(String s){
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(s.length() - 1);
        sb = sb.deleteCharAt(s.length() - 1);
        sb.insert(0, c);
        return sb.toString();
    }
}