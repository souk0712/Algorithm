import java.io.*;
import java.util.*;

class Solution {

    static int[] arr = {4, 1, 2};
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int tmp = n % 3;
            n /= 3;
            
            if(tmp == 0){
                n--;
            }
            
            sb.insert(0, arr[tmp]);
        }
        
        return sb.toString();
    }
}