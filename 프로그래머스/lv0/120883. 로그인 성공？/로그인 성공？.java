import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String[] id_pw, String[][] db) {
        Map<String,String> map = new HashMap<>();
        for(int i = 0;i < db.length; i++){
            String[] tmp = db[i];
            map.put(tmp[0], tmp[1]); 
        }
        
        if(map.containsKey(id_pw[0])){
            if(id_pw[1].equals(map.get(id_pw[0]))){
                return "login";
            }else{
                return "wrong pw";
            }
        }else{
            return "fail";
        }
    }
}