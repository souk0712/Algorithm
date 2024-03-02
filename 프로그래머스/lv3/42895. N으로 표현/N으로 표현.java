import java.io.*;
import java.util.*;

class Solution {

    public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0;i < 9;i++){
            list.add(new HashSet<>());
        }
        
        list.get(0).add(N);
        
        for(int k = 1; k < 8; k++){
            Set<Integer> set = list.get(k);
            
            set.add(makeSeriesNumber(N, k + 1));
            
            for(int i = 0; i < k; i++){
                for(int j = 0; j < k; j++){
                    if(i + j + 1 != k) continue;
                    
                    for(int a : list.get(i)){
                        for(int b : list.get(j)){
                            set.add(a + b);
                            
                            if(a - b > 0)
                                set.add(a - b);
                            
                            set.add(a * b);
                            
                            if(a / b > 0)
                                set.add(a / b);
                        }
                    }
                }
            }
            
            if(set.contains(number)){
                return k + 1;
            }
        }
        
        return -1;
    }
    
    public static int makeSeriesNumber(int n, int cnt){
        int res = 0;
        for(int i = 0; i < cnt; i++){
            res += Math.pow(10, i) * n;
        }
        return res;
    }
}