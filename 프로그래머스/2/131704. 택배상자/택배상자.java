import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[] order) {
        int answer = 0;
        int N = order.length ;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 1; i <= N; i++){
            stack.push(i);
            while(!stack.isEmpty()){
                int o = order[j];
                int top = stack.peek();
                if(top == o){
                    stack.pop();
                    answer++;
                    j++;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}