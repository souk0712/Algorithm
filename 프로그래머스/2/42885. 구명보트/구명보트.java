import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length -1, j = 0 ; i >= j; i--){
            int max = people[i];
            int min = people[j];
            int remind = limit - max;
            if(remind >= min){
                j++;
            }
            answer++;
        }
        
        return answer;
    }
}