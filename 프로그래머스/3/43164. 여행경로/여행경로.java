import java.io.*;
import java.util.*;

class Solution {
    // "ICN" 공항에서 출발
    // "ICN" -> "JFK"
    // "HND" -> "IAD"
    // "JFK" -> "HND"
    static int N;
    static Map<String, Integer> index;
    static ArrayList<Travel>[] list;
    static ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        index = new HashMap<>();
        list = new ArrayList[10000];
        for(int i = 0; i < 10000; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(!index.containsKey(from)){
                index.put(from, i);
                list[i].add(new Travel(to, false));
            }else{
                int ii = index.get(from);
                list[ii].add(new Travel(to, false));
            }
        }
        for(int i = 0; i < 10000; i++){
            if(list[i].isEmpty())continue;
            Collections.sort(list[i]);
        }
        answer = new ArrayList<>();
        
        dfs("ICN");
        Collections.reverse(answer);
        
        return answer.toArray(new String[0]);
    }
    
    static void dfs(String cur){
        if(!index.containsKey(cur)){
            answer.add(cur);
            return;
        }else{
            int idx = index.get(cur);
            for(int i = 0; i < list[idx].size(); i++){
                Travel next = list[idx].get(i);
                if(!next.visit){
                    list[idx].set(i,new Travel(next.next, true));
                    dfs(next.next);
                }
            }
        }
        answer.add(cur);
    }
    
    static class Travel implements Comparable<Travel> {
        String next;
        boolean visit;
        
        Travel(String next, boolean visit){
            this.next = next;
            this.visit = visit;
        }
        
        @Override
        public int compareTo(Travel o){
            return next.compareTo(o.next);
        }
    }
}