import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long start = 0, end = Long.MAX_VALUE;
        
        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            
            if(determination(n, times, mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        return end;
    }
    
    public static boolean determination(int n, int[] times, long num){
        long cnt = 0;
        for(int i = 0; i < times.length; i++) {
            int time = times[i];
            cnt += num / time;
            if(cnt < 0) return false;
        }
        
        return cnt < n;
    }
}