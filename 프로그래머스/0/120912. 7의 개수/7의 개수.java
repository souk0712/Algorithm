import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i = 0; i < array.length; i++){
            String cur = String.valueOf(array[i]);
            for(int j = 0; j < cur.length(); j++){
                if(cur.charAt(j) == '7'){
                    answer++;
                }
            }
        }
        return answer;
    }
}