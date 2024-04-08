import java.io.*;
import java.util.*;

class Solution {
    
    static int N, answer;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        answer = 0;
        boolean[] visit = new boolean[N];
        dfs(visit, dungeons, k, 0);
        return answer;
    }
    
    static void dfs(boolean[] visit, int[][] dungeons, int k, int cnt){
        answer = Math.max(cnt, answer);
        
        for(int l = 0; l < N; l++){
            int[] health = dungeons[l];
            if(visit[l] || k < health[0]) continue;
            visit[l] = true;
            dfs(visit, dungeons, k - health[1], cnt + 1);
            visit[l] = false;
        }
    }
}