import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int N = elements.length;
        int[] ele = new int[2 * N];
        for(int i = 0; i < ele.length; i++){
            ele[i] = elements[i % N];
        }
        
        for(int i = 1; i <= N; i++){
            int left = 0, right = 0;
            int sum = elements[left];
            int cnt = 1;
            
            while(left < N){
                if(i == cnt){
                    set.add(sum);
                }
                
                if(i >= cnt){ 
                    cnt++;
                    right++;
                    sum += ele[right];
                } else{
                    cnt--;
                    left++;
                    sum -= ele[left];
                }
            }
        }
        
        return set.size();
    }
}