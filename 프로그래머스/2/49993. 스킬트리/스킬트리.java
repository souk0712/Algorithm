import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> index = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            index.put(skill.charAt(i), i + 1);
        }
        out:
        for(int i = 0; i < skill_trees.length; i++){
            String skillTree = skill_trees[i];
            boolean[] visit = new boolean[skill.length() + 1];
            visit[0] = true;
            for(int j = 0; j < skillTree.length(); j++){
                char c = skillTree.charAt(j);
                if(index.containsKey(c)){
                    int idx = index.get(c);
                    if(visit[idx - 1]){
                        visit[idx] = true;
                    }else{
                        continue out;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}