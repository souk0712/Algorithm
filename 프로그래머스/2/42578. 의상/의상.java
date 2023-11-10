import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int multiple = 1;
        for(Integer cnt : map.values()){
            multiple *= cnt + 1;
        }
        
        return multiple - 1;
    }
}