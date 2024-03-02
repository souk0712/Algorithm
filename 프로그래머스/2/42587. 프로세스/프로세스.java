import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new LinkedList<>();
        int[] priority = new int[priorities.length];
        for(int i = 0; i < priorities.length; i++){
            priority[i] = priorities[i];
        }
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Process(i, priorities[i]));
        }
        
        Arrays.sort(priority);
        
        int idx = priority.length - 1;
        while(!q.isEmpty()){
            Process process = q.poll();
            if(process.priority == priority[idx]){
                answer++;
                idx--;
                if(process.index == location){
                    break;
                }
            }else{
                q.offer(process);
            }
        }
        
        return answer;
    }
    
    public static class Process implements Comparable<Process>{
        int index, priority;
        
        Process(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Process o){
            return Integer.compare(o.priority, priority);
        }
    }
}