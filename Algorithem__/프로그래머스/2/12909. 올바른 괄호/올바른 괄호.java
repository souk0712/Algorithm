import java.io.*;
import java.util.*;

class Solution {
    
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                        
                case ')':
                    if(stack.isEmpty()){
                        answer = false;
                        break;
                    }else{
                        stack.pop();
                    }
                    break;
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}