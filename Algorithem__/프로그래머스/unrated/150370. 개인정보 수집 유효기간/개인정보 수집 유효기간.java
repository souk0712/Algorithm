import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;
        
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);
            String type = st.nextToken();
            int day = Integer.parseInt(st.nextToken()) * 28;
            map.put(type, day);
        }
        
        st = new StringTokenizer(today, ".");
        int[] todays = new int[3];
        for(int i = 0; i < todays.length; i++){
            todays[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            String type = st.nextToken();
            
            st = new StringTokenizer(date, ".");
            int[] dates = new int[3];
            for(int j = 0; j < dates.length; j++){
                dates[j] = Integer.parseInt(st.nextToken());
            }
            
            int diff = (todays[0] - dates[0]) * 12 * 28 + 
                (todays[1] - dates[1]) * 28 + (todays[2] - dates[2]);
            if(map.get(type) <= diff){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i =0;i < list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}