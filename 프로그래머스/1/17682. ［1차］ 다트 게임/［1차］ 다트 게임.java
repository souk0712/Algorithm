import java.io.*;
import java.util.*;

class Solution {

    public int solution(String dartResult) {
        int[] score = new int[3];
        StringTokenizer options = new StringTokenizer(dartResult, "*#", true);
        int index = 0;
        while(options.hasMoreTokens()){
            String str = options.nextToken();
            if("*".equals(str)){
                score[index - 1] *= 2;
                if(index >= 2){
                    score[index - 2] *= 2;
                }
            } else if("#".equals(str)){
                score[index - 1] *= -1;
            } else{
                StringTokenizer bonus = new StringTokenizer(str, "SDT", true);
                while(bonus.hasMoreTokens()){
                    int digit = Integer.parseInt(bonus.nextToken());
                    String area = bonus.nextToken();
                    switch(area){
                        case "S":
                            score[index++] += digit;
                            break;
                        
                        case "D":
                            score[index++] += (digit * digit);
                            break;
                        
                        case "T":
                            score[index++] += (digit * digit * digit);
                            break;
                        
                        default:
                            break;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 3; i++){
            answer += score[i];
        }
        return answer;
    }
}