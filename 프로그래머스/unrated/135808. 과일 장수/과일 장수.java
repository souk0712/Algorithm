import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < score.length; i++){
            pq.offer(score[i]);
        }
        
        int ans = 0, count = 0;
        int[] arr = new int[m];
        int min = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            int point = pq.poll();
            
            arr[count++] = point;
            min = Math.min(min, point);
            
            if(count == m){
                ans += (min * m);
                count = 0;
                min = Integer.MAX_VALUE;
            }
        }
        
        return ans;
    }
}