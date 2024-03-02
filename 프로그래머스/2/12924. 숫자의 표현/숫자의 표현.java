import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n) {
        int answer = 0;
        int sum = 1, start = 1, end = 1;
        if(n == 1) return 1;
        while(start <= end){
            if(sum <= n){
                sum += ++end;
            }else{
                sum -= start++;
            }
            if(sum == n){
                answer++;
            }
        }
        
        return answer;
    }
}