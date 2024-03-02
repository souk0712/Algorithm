import java.io.*;
import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            String call = callings[i];
            int index = map.get(call);
            if(index != 0){
                String change = swap(players, index - 1, index);
                map.put(change, index);
                map.put(call, index - 1);
            }
        }
        
        return players;
    }
    
    public static String swap(String[] players, int change, int target){
        String tmp = players[change];
        players[change] = players[target];
        players[target] = tmp;
        return tmp;
    }
}