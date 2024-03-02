import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        int ans = 0;
        Arrays.sort(citations);
        for(int i = N - 1; i >= 0; i--){
            int num = citations[i];
            int index = N - i;
            if(num >= index){
                ans = index;
            }else{
                break;
            }
            
        }
        return ans;
    }
}