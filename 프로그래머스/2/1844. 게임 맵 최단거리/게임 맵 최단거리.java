import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }
    
    static int bfs(int[][] maps, int x, int y){
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new int[]{x, y, 1});
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == N - 1 && cur[1] == M - 1){
                return cur[2];
            }
            for(int k = 0; k < dx.length; k++){
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if(mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if(visit[mx][my] || maps[mx][my] == 0) continue;
                q.offer(new int[]{mx, my, cur[2] + 1});
                visit[mx][my] = true;
            }
        }
        return -1;
    }
}