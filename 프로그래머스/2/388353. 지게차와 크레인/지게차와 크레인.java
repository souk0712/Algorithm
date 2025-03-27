import java.io.*;
import java.util.*;

class Solution {
    
    static char[][] map;
    static char BLANK;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new char[n + 2][m + 2];
        BLANK = map[0][0];
        init(storage);
        
        for(int i = 0; i < requests.length; i++){
            String request = requests[i];
            if(request.length() == 2){
                activeCrane(request.charAt(0));
            }else{
                activeForklift(request.charAt(0));
            }
        }
        
        return countContainer();
    }
    
    static int countContainer(){
        int count = 0;
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                if(map[i][j] != BLANK){
                    count++;
                }
            }
        }
        return count;
    }
    
    static void init(String[] storage){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                map[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
    }
    
    static void activeForklift(char c){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n + 2][m + 2];
        char[][] newMap = copyMap();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int k = 0; k < dx.length; k++){
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                
                if(mx < 0 || my < 0 || mx >= n + 2 || my >= m + 2) continue;
                if(visit[mx][my]) continue;
                if(map[mx][my] == BLANK){
                    visit[mx][my] = true;
                    q.offer(new int[]{mx, my});
                }
                if(map[mx][my] == c){
                    newMap[mx][my] = BLANK;
                    visit[mx][my] = true;
                }
            }
        }
        
        map = newMap;
    }
    
    static char[][] copyMap(){
        char[][] res = new char[n + 2][m + 2];
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                res[i][j] = map[i][j];
            }
        }
        return res;
    }
    
    static void activeCrane(char c){
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                if(map[i][j] == c){
                    map[i][j] = BLANK;
                }
            }
        }
    }
}