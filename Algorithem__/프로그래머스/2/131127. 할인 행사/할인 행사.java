import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> gets = new HashMap<>();
        int start = 0, end = 0;
        int total = 0;
        while (end < discount.length) {
            if (total < 10) {
                gets.put(discount[end], gets.getOrDefault(discount[end], 0) + 1);
                end++;
                total++;
            } else {
                gets.put(discount[start], gets.getOrDefault(discount[start], 0) - 1);
                start++;
                total--;
            }

            if (total == 10) {
                boolean check = true;
                for (int i = 0; i < want.length; i++) {
                    if (gets.getOrDefault(want[i], 0) != number[i]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    answer++;
                }
            }
        }
        return answer;
    }
}