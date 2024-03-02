import java.util.*;
import java.io.*;

public class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        while(n >= 1){
            if(n % 2 == 0){
                n /= 2;
                continue;
            }
            n--;
            answer++;
        }
        
        return answer;
    }
}