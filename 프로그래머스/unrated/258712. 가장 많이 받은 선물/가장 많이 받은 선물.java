import java.io.*;
import java.util.*;

class Solution {

    static Map<String, Integer> index = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] gift = new int[N][N];
        int[] point = new int[N];
        int[] next = new int[N];
        
        for(int i = 0; i < N; i++){
            index.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String a = st.nextToken();
            String b = st.nextToken();
            int aIndex = index.get(a);
            int bIndex = index.get(b);
            gift[aIndex][bIndex]++;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                point[i] += gift[i][j];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                point[j] -= gift[i][j];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(gift[j][i] < gift[i][j]){
                    next[i]++;
                } else if(gift[i][j] == gift[j][i]){
                    if(point[i] > point[j]){
                        next[i]++;
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, next[i]);
        }
        
        return answer;
    }
}