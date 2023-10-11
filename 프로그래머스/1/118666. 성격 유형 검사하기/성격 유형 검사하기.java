import java.io.*;
import java.util.*;

class Solution {
    
    static char[] type = {'R', 'T', 'F', 'C', 'M', 'J', 'A', 'N'};

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map <Character, Integer> map = new HashMap<>();
        for(char c : type){
            map.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            String sur = survey[i];
            int choice = choices[i];
            char front  = sur.charAt(0);
            char back  = sur.charAt(1);
            
            if(choice > 4){
                map.put(back, map.get(back) + (choice - 4));
            }else if(choice < 4){
                map.put(front, map.get(front) + (4 - choice));
            }
        }
        
        for(int i = 0; i < type.length; i += 2){
            int f = map.get(type[i]);
            int b = map.get(type[i + 1]);
            if(f > b){
                answer.append(type[i]);
            }else if(f == b){
                if(type[i + 1] > type[i]){
                    answer.append(type[i]);
                }else{
                    answer.append(type[i + 1]);
                }
            }else{
                answer.append(type[i + 1]);
            }
        }
        
        return answer.toString();
    }
}