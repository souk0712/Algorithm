import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remind = n;
        
        while(remind >= a) {
            int q = remind / a;
            int mod = remind % a;
            remind = (q * b) + mod;
            answer += q * b;
        }
        
        return answer;
    }
}