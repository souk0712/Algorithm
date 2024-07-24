import java.io.*;
import java.util.*;

class Solution {

    public String solution(String p) {
        return dfs(p);
    }
    
    static String dfs(String p){
        if(check(p)) return p;
        int left = 0, right = 0;
        String u = "", v = "";
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(c == '('){
                left++;
            }else if(c == ')'){
                right++;
            }
            
            if(left == right){
                u = p.substring(0, i + 1);
                v = p.substring(i + 1, p.length());
                break;
            }
        }
        if(check(u)){
            return u+dfs(v);
        }else{
            StringBuilder sb = new StringBuilder("(");
            sb.append(dfs(v));
            sb.append(')');
            for(int i = 1; i < u.length() - 1; i++){
                char uu = u.charAt(i);
                if(uu == '('){
                    sb.append(')');
                }else if(uu == ')'){
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }
    
    static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push('(');
            }else if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}