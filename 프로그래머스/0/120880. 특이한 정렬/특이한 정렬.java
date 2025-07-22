import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        ArrayList<Num> list = new ArrayList<>();
        for(int i : numlist){
            list.add(new Num(i, Math.abs(n - i)));
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).n;
        }
        return answer;
    }
    
    static class Num implements Comparable<Num>{
        int n, diff;
        
        Num(int n, int diff){
            this.n = n;
            this.diff = diff;
        }
        
        @Override
        public int compareTo(Num o){
            int c = Integer.compare(diff, o.diff);
            if(c == 0){
                return Integer.compare(o.n, n);
            }
            return c;
        }
    }
}