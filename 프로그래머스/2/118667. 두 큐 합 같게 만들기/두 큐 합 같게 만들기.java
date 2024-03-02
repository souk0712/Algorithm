import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        while(sum1 != sum2){
            if(sum1 < sum2){
                int p = q2.poll();
                sum2 -= p;
                sum1 += p;
                q1.offer(p);
            }else{
                int p = q1.poll();
                sum1 -= p;
                sum2 += p;
                q2.offer(p);
            }
            
            answer++;
            
            if(q1.isEmpty() || q2.isEmpty() || answer > queue1.length * 4){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}