import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            int cnt = 0;
            for(int j = i + 1; j < prices.length; j++){
                int next = prices[j];
                cnt++;
                if(price > next){
                    break;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}