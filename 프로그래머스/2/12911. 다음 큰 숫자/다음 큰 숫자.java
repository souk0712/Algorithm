import java.io.*;
import java.util.*;

class Solution {

    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                count++;
            }
        }
        
        for(int k = n + 1; k <= 1_000_000; k++){
            String b = Integer.toBinaryString(k);
            int cnt = 0;
            for(int j = 0; j < b.length(); j++){
                if(b.charAt(j) == '1'){
                    cnt++;
                }
            }
            
            if(cnt == count){
                answer = k;
                break;
            }
        }
        
        return answer;
    }
}