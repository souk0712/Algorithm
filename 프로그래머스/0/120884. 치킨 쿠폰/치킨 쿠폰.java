import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int chicken) {
        int coupon = chicken;
        int answer = 0;
        while(coupon >= 10){
            int freeChicken = coupon / 10;
            coupon = coupon % 10;
            coupon += freeChicken;
            answer += freeChicken;
        }
        return answer;
    }
}