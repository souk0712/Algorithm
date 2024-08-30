import java.io.*;
import java.util.*;

class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            int diff = n - str.length();
            String res = "";
            for(int j = 0; j < diff; j++){
                res += " ";
            }
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '1'){
                    res += '#';
                }else{
                    res += ' ';
                }
            }
            answer[i] = res;
        }
        return answer;
    }
}