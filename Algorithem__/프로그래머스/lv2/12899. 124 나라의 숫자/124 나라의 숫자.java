import java.io.*;
import java.util.*;

class Solution {

    static int[] arr = {4, 1, 2};
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.insert(0, arr[n % 3]);
            n = (n - 1) / 3;
        }
        
        return sb.toString();
    }
}