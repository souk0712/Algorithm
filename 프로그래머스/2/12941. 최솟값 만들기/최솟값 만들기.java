import java.io.*;
import java.util.*;

class Solution{
    
    public int solution(int []A, int []B) {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < A.length; i++){
            a.offer(A[i]);
            b.offer(B[i]);
        }
        
        while(!a.isEmpty()){
            answer += a.poll() * b.poll();
        }
        
        return answer;
    }
}