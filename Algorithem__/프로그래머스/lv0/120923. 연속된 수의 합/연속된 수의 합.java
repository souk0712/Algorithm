import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int n = total / num - (num - 1) / 2;
        for(int i = n, index = 0; i < n + num; i++){
            answer[index++] = i;
        }
        return answer;
    }
}