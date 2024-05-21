import java.io.*;
import java.util.*;

class Solution {
    static final int INF = 100_000_001;
    static int answer;
    
    public int solution(int storey) {
        answer = 100_000_001;
        dfs(storey, 0, 10);
        return answer;
    }
    
    static void dfs(int s, int cnt, int unit){
        if(s <= 0 || s >= INF){
            answer = Math.min(answer, cnt);
            return;
        }
        int minus = s % unit;
        int plus = unit - minus;
        
        dfs(s - minus, cnt + minus / (unit / 10), unit * 10);
        dfs(s + plus, cnt + plus / (unit / 10), unit * 10);
    }
}