import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(num, "0");
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(isPrimeNumber(Double.parseDouble(str))){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrimeNumber(Double n){
        if(n == 0 || n == 1) return false;
        double end = Math.sqrt(n);
        for(int i = 2; i <= end; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}