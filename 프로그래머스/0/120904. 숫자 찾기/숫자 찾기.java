import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int num, int k) {
        int answer = 0;
        String str = String.valueOf(num);
        answer = str.indexOf(String.valueOf(k));
        return answer == -1 ? -1 : answer + 1;
    }
}