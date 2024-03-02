import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int orangeCnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            int t = tangerine[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int v : list){
            if(orangeCnt + v >= k){
                answer++;
                break;
            }else{
                orangeCnt += v;
                answer++;
            }
        }
        
        return answer;
    }
}