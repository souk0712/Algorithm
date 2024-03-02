import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N][N];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < triangle[i].length - 1; j++){
                // 왼쪽
                dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j]);
                // 오른쪽
                dp[i][j + 1] = Math.max(dp[i][j + 1], triangle[i][j + 1] + dp[i - 1][j]);
            }
        }
        
        for(int i = 0;i < N; i++){
            answer = Math.max(answer, dp[N - 1][i]);
        }
        
        return answer;
    }
}