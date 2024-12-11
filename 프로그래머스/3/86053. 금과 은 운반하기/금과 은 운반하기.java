import java.io.*;
import java.util.*;

class Solution {
    
    static final long INF = (long) Math.pow(10, 14) * 4;

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = INF;
        long left = 0;
        long right = INF;
        
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(isBinarySearch(mid, a, b, g, s, w, t)){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
    
    static boolean isBinarySearch(long cur, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long gold = 0;
        long silver = 0;
        long total = 0;
        for(int i = 0; i < g.length; i++){
            int time = t[i];
            int roundTime = time * 2;
            long cnt = cur / roundTime;
            if(cur % roundTime >= time) cnt++;
            long maxWeight = w[i] * cnt;
            
            gold += Math.min(g[i], maxWeight);
            silver += Math.min(s[i], maxWeight);
            total += Math.min(g[i] + s[i], maxWeight);
        }
        return gold >= a && silver >= b && total >= a + b;
    }
}