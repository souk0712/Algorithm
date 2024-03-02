import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int N = numbers.length;
        Stack<int[]> left = new Stack<>();
        Stack<int[]> right = new Stack<>();
        
        Map<Integer,Character> map = new HashMap<>();
        Map<Integer, int[]> pad = new HashMap<>();
        
        for(int i = 1; i <= 9; i += 3){
            map.put(i, 'L');
            map.put(i + 2, 'R');
        }
        
        pad.put(0, new int[]{3, 1});
        
        int index = 1;
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 2; j++){
                pad.put(index++, new int[]{i, j});
            }
        }
        
        left.push(new int[]{3, 0});
        right.push(new int[]{3, 2});
        
        for(int i = 0; i < N; i++){
            int n = numbers[i];
            int[] pos = pad.get(n);
            
            if(map.containsKey(n)){
                char c = map.get(n);
                if(c == 'L'){
                    left.push(new int[]{pos[0], pos[1]});
                }else{
                    right.push(new int[]{pos[0], pos[1]});
                }
                answer.append(c);
            } else{
                
                int[] l = left.peek();
                int[] r = right.peek();
                
                int diff = (Math.abs(l[0] - pos[0]) + Math.abs(l[1] - pos[1])) 
                    - (Math.abs(r[0] - pos[0]) + Math.abs(r[1] - pos[1]));
                
                if(diff == 0){
                    if(hand.equals("right")){
                        right.push(new int[]{pos[0], pos[1]});
                        answer.append('R');
                    }else{
                        left.push(new int[]{pos[0], pos[1]});
                        answer.append('L');
                    }
                }else if(diff > 0){
                    right.push(new int[]{pos[0], pos[1]});
                    answer.append('R');
                }else{
                    left.push(new int[]{pos[0], pos[1]});
                    answer.append('L');
                }
            }
        }
        
        return answer.toString();
    }
}