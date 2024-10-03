import java.io.*;
import java.util.*;

class Solution {
    
    static int N, M;
    static int[] total;
    static int[][] area;
    static final int AREA_MAX = 120001;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;

        int count = 1;
        area = new int[N][M];
        total = new int[AREA_MAX];
        
        // 영역별 총 합 구하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(area[i][j] > 0 || land[i][j] == 0) continue;
                total[count] = bfs(land, i, j, count++);
            }
        }
        
        // 시추 수행
        for(int j = 0; j < M; j++){
            boolean[] visit = new boolean[count];
            int res = 0;
            for(int i = 0; i < N; i++){
                int idx = area[i][j];
                if(land[i][j] == 0 || visit[idx]) continue;
                visit[idx] = true;
                res += total[idx];
            }
            answer = Math.max(res, answer);
        }
        
        return answer;
    }
    
    static int bfs(int[][] land, int i, int j, int index){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        area[i][j] = index;
        int cnt = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;
            for(int k = 0; k < dx.length; k++){
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                
                if(checkRangeOut(mx, my)) continue;
                if(area[mx][my] == index || land[mx][my] == 0) continue;
                
                q.offer(new int[]{mx, my});
                area[mx][my] = index;
            }
        }
        
        return cnt;
    }
    
    static boolean checkRangeOut(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}