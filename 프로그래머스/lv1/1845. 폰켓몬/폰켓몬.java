import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i :nums){
            set.add(i);
        }
        
        int N = nums.length;
        if(set.size() > N / 2) answer = N / 2;
        else answer = set.size();
        
        return answer;
    }
}