import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int[] pointX = {-startX, startX + (m - startX) * 2, startX, startX};
            int[] pointY = {startY, startY, startY + (n - startY) * 2, -startY};
            int res = Integer.MAX_VALUE;
            
            for(int j = 0; j < 4; j++){
                int ballX = balls[i][0];
                int ballY = balls[i][1];
                if(ballX == pointX[j] || ballY == pointY[j]) continue;
                int width = Math.abs(pointX[j] - ballX);
                int height = Math.abs(pointY[j] - ballY);
                int distance = width * width + height * height;
                res = Math.min(distance, res);
                System.out.println("ballX: "+ballX+", ballY: "+ballY+", width: "+width+", height: "+height+", distance: "+distance);
            }
            answer[i] = res;
        }
        return answer;
    }
    
    static int[] getNewPoint(int x, int y, int length){
        
        return new int[]{};
    }
}