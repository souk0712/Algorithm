import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] prefixSum;
    static int N, M;
    
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        prefixSum = new int[N + 1][M + 1];
        
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];       
            if(type == 1) degree = -degree;
            
            prefixSum[r1][c1] += degree;
            prefixSum[r2 + 1][c2 + 1] += degree;
            prefixSum[r2 + 1][c1] += -degree;
            prefixSum[r1][c2 + 1] += -degree;
        }
        // 좌 -> 우
        for(int i = 0; i < N; i++){
            for(int j = 1; j < M; j++){
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        // 상 -> 하
        for(int j = 0; j < M; j++){
            for(int i = 1; i < N; i++){
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] + prefixSum[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}