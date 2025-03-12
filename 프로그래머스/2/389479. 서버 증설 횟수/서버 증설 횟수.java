import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] activeServerTime = new int[24];
        for(int i = 0; i < players.length; i++){
            int player = players[i];
            int needServer = player / m;
            int currentServer = activeServerTime[i];
            if(needServer > currentServer){
                answer += (needServer - currentServer);
                for(int j = i; j < k + i; j++){
                    if(j >= 24) break;
                    activeServerTime[j] += (needServer - currentServer);
                }
            }
        }
        return answer;
    }
}