import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answerBuilder = new StringBuilder();
        
        char[] arr = number.toCharArray();
        
        int len = arr.length - k;
        
        int start = 0;
        for(int i = 0; i < len; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(arr[j] > max){
                    max = arr[j];
                    start = j + 1;
                }
            }
            
            answerBuilder.append(max);
        }
        
        answer = answerBuilder.toString();
        return answer;
    }
}