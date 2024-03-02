import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++){
            int value = score[i];
            if(pq.size() >= k){
                int peek = pq.peek();
                if(peek < value){
                    pq.poll();
                    pq.offer(value);
                }
            }else{
                pq.offer(value);
            }
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}