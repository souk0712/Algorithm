import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String s) {

        String binary = s;
        int zeroCnt = 0;
        int several = 0;
        
        while(!"1".equals(binary)){
            int count = 0;
            for(int i = 0; i < binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    count++;
                }else{
                    zeroCnt++;
                }
            }

            binary = Integer.toBinaryString(count);
            several++;
        }
        
        int[] answer = new int[]{several, zeroCnt};
        
        return answer;
    }
}