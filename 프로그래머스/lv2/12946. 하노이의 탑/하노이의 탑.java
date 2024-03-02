import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int[] arr = list.get(i);
            answer[i] = arr;
        }
        
        return answer;
    }
    
    public static void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            move(n, start, end);
            return;
        }
        hanoi(n - 1, start, end, mid);
        move(n, start, end);
        hanoi(n - 1, mid, start, end);
        return;
    }
    
    public static void move(int n, int start, int end){
        list.add(new int[]{start, end});
        return;
    }
}