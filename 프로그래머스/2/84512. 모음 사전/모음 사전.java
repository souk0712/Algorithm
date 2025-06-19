import java.io.*;
import java.util.*;

class Solution {
    
    static char[] character = new char[]{'A','E','I','O','U'};
    static StringBuilder pick;
    static int ans;
    static ArrayList<String> list;
    
    public int solution(String word) {
        pick = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        perm(0);
        for(int i = 0; i < list.size(); i++){
            if(word.equals(list.get(i))){
                ans = i + 1;
                break;
            }
        }
        
        return ans;
    }
    
    static void perm(int cnt){
        if(cnt == 5){
            return;
        }
        
        for(int j = 0; j < character.length; j++){
            pick.insert(cnt, character[j]);
            list.add(pick.toString());
            perm(cnt + 1);
            pick.deleteCharAt(cnt);
        }
    }
}