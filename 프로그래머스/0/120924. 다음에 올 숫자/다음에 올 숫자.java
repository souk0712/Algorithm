import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int one = common[1] - common[0];
        int second = common[2] - common[1];
        if(one == second){
            answer = common[common.length - 1] + one;
        }else{
            int rate = common[1] / common[0];
            answer = common[common.length - 1] * rate;
        }
        return answer;
    }
}