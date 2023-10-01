import java.io.*;
import java.util.*;

class Solution {
    
    static String[] base = {"aya", "ye", "woo", "ma"};
    static String[] doubleBase = {"ayaaya", "yeye", "woowoo", "mama"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++){
            StringBuilder str = new StringBuilder(babbling[i]);

            for(int j = 0; j < base.length; j++){
                String b = base[j];
                String bb = doubleBase[j];
                int index = 0;
                
                if(str.indexOf(bb) != -1){
                    continue;
                }
                
                while(index != -1){
                    index = str.indexOf(b);
                    if(index != -1){
                        str.replace(index, index + b.length(), "-");
                    }
                }
            }
            boolean check = false;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) != '-'){
                    check = true;
                    break;
                }
            }
            
            if(!check){
                answer++;
            }
        }
        
        return answer;
    }
}