import java.io.*;
import java.util.*;

class Solution {
    
    static String[] ori = {"C#", "D#", "F#", "G#", "A#", "B#"};
    static String[] re = {"H", "I", "J", "K", "L", "M"};
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        for(int i = 0; i < ori.length;i++){
            m = m.replaceAll(ori[i], re[i]);
        }
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for(int j = 0; j < musicinfos.length; j++){
            StringTokenizer st = new StringTokenizer(musicinfos[j], ",");
            String start = st.nextToken();
            String end = st.nextToken();
            String title = st.nextToken();
            String music = st.nextToken();
            
            for(int i = 0; i < ori.length;i++){
                music = music.replaceAll(ori[i], re[i]);
            }
            
            int total = calculateTime(start, end);
            int share = total / music.length();
            int remain = total % music.length();
            
            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < share; l++){
                sb.append(music);
            }
            for(int l = 0; l < remain; l++){
                sb.append(music.charAt(l));
            }
            if(sb.toString().contains(m)){
                pq.offer(new Data(title, total));
            }
        }
        if(!pq.isEmpty()){
            answer = pq.poll().title;
        }else{
            answer = "(None)";
        }
        return answer;
    }
    
    static int calculateTime(String start, String end){
        String[] starts = start.split(":");
        int sh = Integer.parseInt(starts[0]);
        int sm = Integer.parseInt(starts[1]);
        
        String[] ends = end.split(":");
        int eh = Integer.parseInt(ends[0]);
        int em = Integer.parseInt(ends[1]);
        
        if(em < sm){
            eh -= 1;
            em += 60;
        }
        return (eh - sh) * 60 + (em - sm);
    }
    
    static class Data implements Comparable<Data>{
        String title;
        int total;
        
        Data(String title, int total){
            this.title = title;
            this.total = total;
        }
        
        @Override
        public int compareTo(Data o){
            return Integer.compare(o.total, total);
        }
    }
}