import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<works.length;i++){
            pq.offer(works[i]);
        }
        while(n-- > 0){
            int max = pq.poll();
            pq.offer(--max);
        }
        
        while(!pq.isEmpty()){
            int p = pq.poll();
            if(p < 0) continue;
            answer += p * p;
        }
        
        return answer;
    }
}