import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        answer.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
        
        return answer.toString();
    }
}