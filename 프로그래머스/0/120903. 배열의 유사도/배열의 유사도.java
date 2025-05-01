import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s1.length; i++){
            set.add(s1[i]);
        }
        for(int i = 0;i<s2.length;i++){
            if(set.contains(s2[i])){
                answer++;
            }
        }
        return answer;
    }
}