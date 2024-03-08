import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visit;
    static int startX, startY;
    static int goalX, goalY;
    static int N, M;
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visit = new boolean[N][M];
        startX = startY = goalX = goalY = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    startX = i;
                    startY = j;
                }else if(map[i][j] == 'G'){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        visit[startX][startY] = true;
        
        return bfs();
    }
    
    static int bfs(){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{startX, startY, 0});
        
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            if(cur[0] == goalX && cur[1] == goalY){
                return cur[2];
            }
            
            for(int k = 0; k < dx.length; k++){
                int[] res = move(cur[0], cur[1], k);
                if(visit[res[0]][res[1]]) continue;
                visit[res[0]][res[1]] = true;
                dq.offer(new int[]{res[0], res[1], cur[2] + 1});
            }
        }
        return -1;
    }
    
    static int[] move(int x, int y, int d){
        while(true){
            int mx = x + dx[d];
            int my = y + dy[d];
            if(mx < 0 || my < 0 || mx >= N || my >= M) break;
            if(map[mx][my] == 'D') break;
            x = mx;
            y = my;
        }
        return new int[]{x, y};
    }
}