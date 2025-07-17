import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<Integer> list;
    static int[] pick;
    
    public int[] solution(int n, long k) {
        list = new ArrayList<>();
        long facN = 1;
        // 배열에 1 ~ n까지 넣기
        for(int i = 1; i <= n; i++){
            list.add(i);
            // n! 구하기
            facN *= i;
        }
        int[] answer = new int[n];
        int index = 0;
        // (n-1)!을 만들기 위한 분모
        int bottom = n;
        // 0번쨰부터 시작해야해서
        k--;
        while(index < n){
            facN = (facN / bottom--);
            long moc = k / facN;
            k %= facN;
            answer[index++] = list.remove((int) moc);
        }
        return answer;
    }
}