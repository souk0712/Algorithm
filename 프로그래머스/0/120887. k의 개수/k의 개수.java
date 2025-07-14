import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int i, int j, int k) {
        int answer = 0;
        char ks = Character.forDigit(k, 10);
        for(int ii = i; ii <= j; ii++){
            String s = String.valueOf(ii);
            for(int jj = 0; jj < s.length(); jj++){
                if(ks == s.charAt(jj)){
                    answer++;
                }
            }
        }
        return answer;
    }
}