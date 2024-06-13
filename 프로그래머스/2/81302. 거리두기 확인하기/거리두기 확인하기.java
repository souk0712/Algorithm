import java.io.*;
import java.util.*;

class Solution {
    
    static final int MAX = 5; 
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static char[][] map;
    static ArrayList<int[]> list;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[MAX];
        
        for(int i = 0; i < places.length; i++){
            map = new char[MAX][MAX];
            String[] place = places[i];
            list = new ArrayList<>();
            
            for(int j = 0; j < MAX; j++){
                for(int k = 0; k < MAX; k++){
                    map[j][k] = place[j].charAt(k);
                    
                    if(map[j][k] == 'P'){
                        list.add(new int[]{j, k});
                    }
                }
            }
            boolean check = true;
            for(int j = 0; j < list.size(); j++){
                if(!bfs(list.get(j))){
                    check = false;
                    break;
                }
            }
            
            if(check){
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    static boolean bfs(int[] start){
        boolean[][] visit  =new boolean[MAX][MAX];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start[0], start[1], 0});
        visit[start[0]][start[1]] = true;
        
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            if(cur[2] >= 2) continue;
            
            for(int k = 0; k < dx.length; k++){
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if(mx < 0 || my < 0 || mx >= MAX || my >= MAX) continue;
                if(map[mx][my] == 'X' || visit[mx][my]) continue;
                if(map[mx][my]=='P'){
                    return false;
                }
                visit[mx][my] = true;
                dq.offer(new int[]{mx, my, cur[2] + 1});
                
            }
        }
        return true;
    }
}