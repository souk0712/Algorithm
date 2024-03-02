import java.io.*;
import java.util.*;

class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] isWinNums = new boolean[46];
        for(int i = 0;i<win_nums.length;i++){
            int pos = win_nums[i];
            isWinNums[pos] = true;
        }
        int zero = 0, correct = 0;
        for(int i = 0; i < lottos.length; i++){
            int lottoNum = lottos[i];
            if(lottoNum == 0){
                zero++;
            }else if(isWinNums[lottoNum]){
                correct++;
            }
        }
        
        int max;
        if(correct + zero > 1){
            max = 7 - (correct + zero);
        } else{
            max = 6;
        }
        
        int min;
        if(correct > 1){
            min = 7 - correct;  
        } else{
            min = 6;
        }
        
        return new int[]{max, min};
    }
}