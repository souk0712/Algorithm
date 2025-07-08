import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String before, String after) {
        int answer = 1;
        int length = before.length();
        int[] alphaBefore = new int[26];
        int[] alphaAfter = new int[26];
        for(int i = 0; i < length; i++){
            alphaBefore[before.charAt(i) - 'a']++;
            alphaAfter[after.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < alphaBefore.length; i++){
            if(alphaAfter[i] != alphaBefore[i]){
                answer = 0;
                break;
            }
        }
        return answer;
    }
}