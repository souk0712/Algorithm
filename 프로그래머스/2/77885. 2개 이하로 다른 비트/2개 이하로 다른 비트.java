import java.io.*;
import java.util.*;


class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0;i<numbers.length;i++){
            String number = Long.toString(numbers[i], 2);
            boolean check = false;
            StringBuilder sb = new StringBuilder(number);
            for(int j = sb.length() - 1; j >= 0; j--){
                if(sb.charAt(j) == '0'){
                    sb.setCharAt(j, '1');
                    if(j + 1 < sb.length()){
                        sb.setCharAt(j + 1, '0');
                    }
                    check = true;
                    break;
                }
            }
            if(!check){
                sb.insert(0, 1);
                if(1 < sb.length()){
                    sb.setCharAt(1, '0');
                }
            }
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        return answer;
    }
}