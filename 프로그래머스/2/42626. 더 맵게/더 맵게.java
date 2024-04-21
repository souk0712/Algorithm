import java.io.*;
import java.util.*;

// 7:57 ~ 8:13
// 
class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
    
        while(!pq.isEmpty()){
            int one = pq.poll();
            if(one >= K) break;
            if(pq.isEmpty()){
                return -1;
            }
            int two = pq.poll();
            int next = one + two * 2;
            pq.offer(next);
            answer++;
        }
        return answer;
    }
}