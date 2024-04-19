import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[]dp = new int[1001];
        for(int i = 1; i < 1001; i++){
            dp[i] = i * i - dp[i - 1];
        }
        int num = 1;
        int dir = 0;
        int x = 0;
        int y = 0;
        map[x][y] = num++;
        while(num <= dp[n]){
            int mx = x + dx[dir];
            int my = y + dy[dir];
            if(mx < 0 || my < 0 || mx >= n || my >= n){
                dir = (dir + 1) % 3;
                continue;
            }
            if(map[mx][my] != 0){
                dir = (dir + 1) % 3;
                continue;
            }
            map[mx][my] = num++;
            x = mx;
            y = my;
        }
        int[] answer = new int[dp[n]];
        for(int i = 0,index = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) continue;
                answer[index++] = map[i][j];
            }
        }
        return answer;
    }
}