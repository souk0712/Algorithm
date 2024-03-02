import java.io.*;
import java.util.*;

class Solution {
    
    static int[] board;
    static boolean[] visit;
    static int ans;
    
    public int solution(int n) {
        board = new int[n];
        visit = new boolean[n];
        ans = 0;
        
        nqueen(n, 0);
        
        return ans;
    }
    
    static void nqueen(int n, int cnt){
        if(cnt == n){
            ans++;
            
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(visit[i]) continue;
            
            board[cnt] = i;
            visit[i] = true;
            
            if(promising(cnt)){
                nqueen(n, cnt + 1);
            }
            
            visit[i] = false;
        }
    }
    
    static boolean promising(int cnt){
        for(int i = 0; i < cnt; i++){
            if(board[cnt] == board[i] || cnt - i == Math.abs(board[cnt] - board[i])){
                return false;
            }
        }
        return true;
    }
}