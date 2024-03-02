import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int foodCnt = food[i] / 2;
            if(food[i] != 1){
                for(int j = 0; j < foodCnt; j++){
                    answer.append(i);
                }
            }
        }
        
        answer.append(0);
        
        for(int i = food.length - 1; i >= 0; i--){
            int foodCnt = food[i] / 2;
            if(food[i] != 1){
                for(int j = 0; j < foodCnt; j++){
                    answer.append(i);
                }
            }
        }
        
        return answer.toString();
    }
}