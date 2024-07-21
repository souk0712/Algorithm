import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            dq.offer(0);
        }

        int index = 0;

        while (index < truck_weights.length) {
            int truck = truck_weights[index];
            answer++;
            dq.poll();

            if (sum(dq) + truck <= weight) {
                dq.offer(truck);
                index++;
            } else {
                dq.offer(0);
            }
        }

        answer += dq.size();

        return answer;
    }

    static int sum(ArrayDeque<Integer> dq) {
        int sum = 0;
        for (int i : dq) {
            sum += i;
        }
        return sum;
    }
}