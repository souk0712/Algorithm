import java.io.*;
import java.util.*;

class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            int diff = n - str.length();
            String temp = "";
            for(int j = 0; j < diff; j++){
                temp += "0";
            }
            str = temp + str;
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            answer[i] = str;
        }
        return answer;
    }
}