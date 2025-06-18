import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                res.add(numlist[i]);
            }
        }
        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}