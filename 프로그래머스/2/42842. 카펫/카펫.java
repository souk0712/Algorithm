import java.io.*;
import java.util.*;

class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int half = brown / 2;
        
        for(int i = 3; i < half; i++){
            for(int j = half - i; j > 0; j--){
                if(yellow == carpet(i, j)){
                    answer[0] = i;
                    answer[1] = j + 2;
                    break;
                }
            }
        }
        
        return answer; 
    }
    
    public static int carpet(int r, int c){
         return (r - 2) * c;
    }
}