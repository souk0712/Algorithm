import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        String color = board[h][w];
        for(int k = 0; k < dx.length; k++){
            int mx = h + dx[k];
            int my = w + dy[k];
            if(mx < 0 || my < 0 || mx >= N || my >= M) continue;
            String c = board[mx][my];
            if(c.equals(color)){
                answer++;
            }
        }
        return answer;
    }
}