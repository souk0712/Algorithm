import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue <Work> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int remainProgress = 100 - progresses[i];
            int speed = speeds[i];
            int needDay = (int)Math.ceil((double) remainProgress / speed);
            q.offer(new Work(progresses[i], speed, needDay));
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        int before = q.poll().needDay;
        int cnt = 1;
        
        while(!q.isEmpty()){
            Work cur = q.poll();
            if(before >= cur.needDay){
                cnt++;
            }else{
                res.add(cnt);
                cnt = 1;
                before = cur.needDay;
            }
        }
        res.add(cnt);
        
        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    static class Work {
        
        int progress, speed, needDay;
        
        Work(int progress, int speed, int needDay){
            this.progress = progress;
            this.speed = speed;
            this.needDay = needDay;
        }
    }
}