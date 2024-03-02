import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] str = new String[N];
        for(int i = 0; i < N; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        
        if(str[0].equals("0")) return "0";
        
        for(int i = 0; i < N; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}