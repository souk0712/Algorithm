import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        ArrayList<Long> list = new ArrayList<>();
        for(String ban : bans){
            list.add(convertToLong(ban));
        }
        
        Collections.sort(list);
        
        for(long l : list){
            if(l <= n){
                n++;
                continue;
            }
            break;
        }
        return convertToString(n);
    }
    
    static long convertToLong(String s){
        long res = 0;
        for(int i = 0; i < s.length(); i++){
            long value = s.charAt(i) - 'a' + 1;
            res = res * 26 + value;
        }
        return res;
    }
    
    static String convertToString(long value){
        StringBuilder sb = new StringBuilder();
        
        while(value-- > 0){
            char c = (char)('a' + (value % 26));
            sb.append(c);
            value /= 26;
        }
        return sb.reverse().toString();
    }
} 