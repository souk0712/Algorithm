import java.io.*;
import java.util.*;

    // S : 시작 지점
    // E : 출구
    // L : 레버
    // O : 통로
    // X : 벽
class Solution {
    
    static int N, M;
    static Pos start, end, laber;
    static char[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new char[N][M];
        
        for(int i = 0; i < maps.length; i++){
            String map = maps[i];
            for(int j = 0; j < map.length(); j++){
                char m = map.charAt(j);
                board[i][j] = m;
                if(m == 'S'){
                    start = new Pos(i, j, 0);
                }else if(m == 'E'){
                    end = new Pos(i, j, 0);
                }else if(m =='L'){
                    laber = new Pos(i, j, 0);
                }
            }
        }
        
        int first = bfs(start, laber);
        if(first == -1) return -1;
        int second = bfs(laber, end);
        if(second == -1) return -1;
        
        return first + second;
    }
    
    static int bfs(Pos from, Pos to){
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        visit[from.x][from.y] = true;
        q.offer(from);
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.x == to.x && cur.y == to.y) return cur.cnt;
            
            for(int k = 0; k < dx.length; k++){
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                
                if(mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if(visit[mx][my] || board[mx][my] == 'X')continue;
                
                visit[mx][my] = true;
                q.offer(new Pos(mx, my, cur.cnt + 1));
            }
        }
        return -1;
    }
    
    static class Pos {
        int x, y, cnt;
        
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}