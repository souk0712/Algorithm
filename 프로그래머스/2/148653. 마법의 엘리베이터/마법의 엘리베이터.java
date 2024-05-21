import java.io.*;
import java.util.*;

class Solution {
    static int answer, origin;
    
    public int solution(int storey) {
        answer = 100_000_001;
        origin = storey;
        dfs(storey, 0, 10);
        return answer;
    }
    
    static void dfs(int s, int cnt, int unit){
        if(s <= 0){
            answer = Math.min(answer, cnt);
            return;
        }
        int minus = s % unit;
        int plus = unit - minus;
        
        dfs(s - minus, cnt + minus / (unit / 10), unit * 10);
        dfs(s + plus, cnt + plus / (unit / 10), unit * 10);
    }
}