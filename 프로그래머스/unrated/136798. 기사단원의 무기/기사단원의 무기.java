import java.io.*;
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int m = countMeasure(i);
            if(limit < m){
                answer += power;
            }else{
                answer += m;
            }
        }
       
        return answer;
    }
    
    public static int countMeasure(int n){
        int count = 0;
        
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                if(n / i == i){
                    count += 1;
                }else{
                    count += 2;
                }
            }
            
        }
        return count;
    }
}