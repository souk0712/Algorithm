import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        ArrayList<Integer> orderMats = new ArrayList<>();
        for(int i : mats){
            orderMats.add(i);
        }
        orderMats.sort(Collections.reverseOrder());
        
        out:
        for(int k = 0; k < orderMats.size(); k++){
            for(int i = 0; i < park.length; i++){
                for(int j = 0; j < park[0].length; j++){
                    if("-1".equals(park[i][j]) && checkSpace(park, i, j, orderMats.get(k))){
                        answer = orderMats.get(k);
                        break out;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static boolean checkSpace(String[][] park, int i, int j, int size){
        for(int r = i; r < i + size; r++){
            for(int c = j; c < j + size; c++){
                if(r >= park.length || c >= park[0].length) return false;
                if(!"-1".equals(park[r][c])){
                    return false;
                }
            }
        }
        return true;
    }
}