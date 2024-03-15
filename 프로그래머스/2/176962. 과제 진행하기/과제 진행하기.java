import java.io.*;
import java.util.*;

class Solution {
    
    static int N;
    
    public String[] solution(String[][] plans) {
        N = plans.length;
        ArrayList<String> answer = new ArrayList<>();
        PriorityQueue<Schedule> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] plan = plans[i];
            String name = plan[0];
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int playTime = Integer.parseInt(plan[2]);
            pq.offer(new Schedule(name, start, playTime));
        }

        Stack<Schedule> stack = new Stack<>();
        while (!pq.isEmpty()) {
            Schedule cur = pq.poll();
            int curTime = cur.start;

            // 새로운 과제가 남아있는 경우
            if (!pq.isEmpty()) {
                Schedule next = pq.peek();

                // 지금 과제를 끝낸 후에도 다음 과제 시작 시간까지 시간이 남는 경우
                if (curTime + cur.playTime < next.start) {
                    answer.add(cur.name);
                    curTime += cur.playTime;

                    // 잠시 멈춘 과제가 있는 경우, 남는 시간동안 멈췄던 과제 해결
                    while (!stack.isEmpty()) {
                        Schedule remain = stack.pop();

                        // 멈춘 과제를 다음 새로운 과제 전에 끝낼 수 있는 경우
                        if (curTime + remain.playTime <= next.start) {
                            curTime += remain.playTime;
                            answer.add(remain.name);
                        } else {    // 못 끝내는 경우
                            int t = remain.playTime - (next.start - curTime);
                            stack.push(new Schedule(remain.name, remain.start, t));
                            break;
                        }
                    }
                } 
                // 지금 과제를 끝낸 후, 다음 과제 시작 시간인 경우
                else if (cur.start + cur.playTime == next.start) {
                    answer.add(cur.name);
                } else {
                    int t = next.start - curTime;
                    stack.push(new Schedule(cur.name, cur.start, cur.playTime - t));
                }
            } else {
                if (stack.isEmpty()) {
                    answer.add(cur.name);
                } else {
                    answer.add(cur.name);
                    while (!stack.isEmpty()) {
                        Schedule remain = stack.pop();
                        answer.add(remain.name);
                    }
                }
            }
        }

        String[] ans = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    static class Schedule implements Comparable<Schedule> {
        int start, playTime;
        String name;

        Schedule(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Schedule o) {
            return Integer.compare(start, o.start);
        }
    }
}