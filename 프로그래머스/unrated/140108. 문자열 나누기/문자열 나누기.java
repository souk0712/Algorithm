import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 1;
        char x = s.charAt(0);
        int xCnt = 1, noCnt = 0;
        for(int i = 1; i < s.length(); i++){
            if(x == s.charAt(i)){
                xCnt++;
            }else{
                noCnt++;
            }
            
            if(i + 1 < s.length() && xCnt == noCnt){
                x = s.charAt(i + 1);
                xCnt = 0;
                noCnt = 0;
                answer++;
            }
        }
        
        return answer;
    }
}