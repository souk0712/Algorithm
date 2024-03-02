import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] notPrime, visit;
    static int[] pick;
    static int N = 3_001;
    static int answer;
    
    public int solution(int[] nums) {
        answer = 0;        
        visit = new boolean[nums.length];
        pick = new int[3];
        
        // 에라토스테네스의 체
        notPrime = new boolean[N];
        notPrime[0] = notPrime[1] = true;
        
        for(int i = 2; i * i < N; i++){
            if(!notPrime[i]){
                for(int j = i * i; j < N; j += i){
                    notPrime[j] = true;
                }
            }
        }
        
        comb(nums, 0, 0);
        
        return answer;
    }
    
    public static void comb(int[] nums, int start, int cnt){
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i < pick.length; i++){
                sum += pick[i];
            }
            
            if(!notPrime[sum]){
                answer++;
            }
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(visit[i]) continue;
            
            visit[i] = true;
            pick[cnt] = nums[i];
            
            comb(nums, i + 1, cnt + 1);
            
            visit[i] = false;
        }
    }
}