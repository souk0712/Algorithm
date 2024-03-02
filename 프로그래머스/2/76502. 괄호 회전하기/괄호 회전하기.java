import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (checkCorrectString(sb.toString())) {
                answer++;
            }
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
        }

        return answer;
    }
    
    public static boolean checkCorrectString(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;

                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;

                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}