import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Data>> map = new HashMap<>();
        Map<Integer, String> indexToGenres = new HashMap<>();
        Map<String, Integer> genresToIndex = new HashMap<>();
        int[] sum = new int[100];
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0, sumIndex = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            if(map.containsKey(g)){
                ArrayList<Data> l = map.get(g);
                l.add(new Data(i, p));
                map.put(g, l);
                int gI = genresToIndex.get(g);
                sum[gI] += p;
            }else{
                ArrayList<Data> l = new ArrayList<>();
                l.add(new Data(i, p));
                map.put(g, l);
                sum[sumIndex] += p;
                indexToGenres.put(sumIndex, g);
                genresToIndex.put(g,sumIndex++);
            }
        }
        
        ArrayList<Data> newSum = new ArrayList<>();
        for(int i = 0; i < sum.length; i++){
            if(sum[i] != 0){
                newSum.add(new Data(i, sum[i]));
            }
        }
        
        Collections.sort(newSum);
        
        for(Data d : newSum){
            String genre = indexToGenres.get(d.index);
            ArrayList<Data> list = map.get(genre);
            PriorityQueue<Data> pq = new PriorityQueue<>(list);
            int c = 0;
            while(!pq.isEmpty()){
                Data cur = pq.poll();
                answer.add(cur.index);
                if(c == 1) break;
                c++;
            }
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    class Data implements Comparable<Data> {
        int index, count;
        
        Data(int index, int count){
            this.index = index;
            this.count = count;
        }
        
        @Override
        public int compareTo(Data o){
            int c = Integer.compare(o.count,this.count);
            if(c == 0){
                return Integer.compare(index,o.index);
            }else{
                return c;
            }
        }
        
        @Override
        public String toString(){
            return "index: "+index+", count: "+count;
        }
    }
}