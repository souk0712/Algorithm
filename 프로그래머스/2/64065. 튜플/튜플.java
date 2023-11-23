import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        boolean[] nums = new boolean[100_001];
        String[] outer = s.substring(2, s.length() - 2).split("\\},\\{");
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.size(),o2.size())
        );
        StringTokenizer inner;
        for(String str : outer){
            inner = new StringTokenizer(str, ",");
            ArrayList<Integer> list = new ArrayList<>();
            while(inner.hasMoreTokens()){
                int i = Integer.parseInt(inner.nextToken());
                list.add(i);
            }
            if(!list.isEmpty()){
                pq.offer(list);
            }
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        while(!pq.isEmpty()){
            ArrayList<Integer> cur = pq.poll();
            for(int i = 0; i < cur.size(); i++){
                int j = cur.get(i);
                if(nums[j]){
                    
                }else{
                    answerList.add(j);
                    nums[j] = true;
                }
            }
        }
                
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}