import java.io.*;
import java.util.*;

class Solution {
    
    static Set<Integer> pick;
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        pick = new HashSet<>();
        comb(n, 1, 0, q, ans);
        
        return answer;
    }
    
    static boolean checkAnswer(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int cnt = 0;
            for(int j = 0; j < q[i].length; j++){
                int qq = q[i][j];
                if(pick.contains(qq)){
                    cnt++;
                }
            }
            if(ans[i] != cnt){
                return false;
            }
        }
        return true;
    }
    
    static void comb(int n, int start, int cnt, int[][] q, int[] ans){
        if(cnt == 5){
            if(checkAnswer(q, ans)){
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++){
            if(pick.contains(i)) continue;
            pick.add(i);
            comb(n, i + 1, cnt + 1, q, ans);
            pick.remove(i);
        }
    }
}