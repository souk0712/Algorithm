import java.io.*;
import java.util.*;

class Solution {
    
    static int[] A, B;
    public int solution(int[] topping) {
        int answer = 0;
        A = new int[10_001];
        for(int i = 0; i < topping.length; i++){
            A[topping[i]]++;
        }
        B = new int[10_001];
        int a = 0;
        int b = 0;
        
        for(int i = 1; i < A.length; i++){
            if(A[i] > 0){
                a++;
            }
        }
        
        for(int i = 0; i < topping.length; i++){
            int t = topping[i];
            if(--A[t] <= 0){
                a--;
            }
            
            if(B[t]++ == 0){
                b++;
            }
            
            if(a == b){
                answer++;
            }
        }
        return answer;
    }
}