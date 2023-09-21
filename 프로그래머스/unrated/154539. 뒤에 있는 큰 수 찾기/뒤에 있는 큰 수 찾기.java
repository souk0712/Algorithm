import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++){
            int n = numbers[i];
            while(!stack.isEmpty()){
                if(numbers[stack.peek()] < n){
                    int index = stack.pop();
                    answer[index] = n;
                }else{
                    break;
                }
            }
            stack.push(i);
        }
        
         while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = -1;
        }
        
        return answer;
    }
}