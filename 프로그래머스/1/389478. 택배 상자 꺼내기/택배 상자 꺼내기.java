import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n % w == 0 ? n / w : n / w + 1;
        int[][] table = new int[h][w];
        
        int[] numPoint = getPoint(w, num);
        int[] lastPoint = getPoint(w, n);
        answer = h - numPoint[0];
        // 짝수 -> 마지막 줄이 왼쪽
        if(lastPoint[0] % 2 == 0){
            if(numPoint[1] > lastPoint[1]){
                answer -= 1;
            }
        }else{  // 홀수 -> 마지막 줄이 오른쪽
            if(numPoint[1] < lastPoint[1]){
                answer -= 1;
            }
        }
        return answer;
    }
    
    static int[] getPoint(int w, int num){
        int[] res = new int[2];
        res[0] = (num - 1) / w;
        // 짝수 -> 줄이 왼쪽부터 시작
        if(res[0] % 2 == 0){
            res[1] = (num - 1) % w;
        }else{  // 홀수 -> 줄이 오른쪽부터 시작
            res[1] = w - ((num - 1) % w) - 1;
        }
        
        return res;
    }
}