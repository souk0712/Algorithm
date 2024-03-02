import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();
        for(int i =0;i<numbers.length;i++){
            for(int j =i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:set){
            pq.add(i);
        }
        int size = pq.size();
        int[] answer = new int[size];
        int index = 0;
        while(!pq.isEmpty()){
            answer[index++] = pq.poll();
        }
        
        return answer;
    }
}