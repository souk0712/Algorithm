import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder ingStr = new StringBuilder();
        for(int i : ingredient){
            ingStr.append(i);
            if(ingStr.length() > 3 && 
               ingStr.subSequence(ingStr.length() - 4, ingStr.length()).equals("1231")){
                ingStr.delete(ingStr.length() - 4, ingStr.length());
                answer++;
            }
        }

        return answer;
    }
}