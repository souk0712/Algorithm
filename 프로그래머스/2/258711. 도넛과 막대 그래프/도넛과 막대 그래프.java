import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static int[] answer;
    static int[] inCount, outCount;
    
    public int[] solution(int[][] edges) {
                answer = new int[4];
        int N = 0;
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            N = Math.max(N, to);
            N = Math.max(N, from);
        }
        inCount = new int[N + 1];
        outCount = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            list[to].add(from);
            outCount[to]++;     // out
            inCount[from]++;   // in
        }

        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i <= N; i++) {
            if (inCount[i] == 0 && outCount[i] > max) {
                max = outCount[i];
                maxIndex = i;
            }
        }
        answer[0] = maxIndex;

        for (int i = 0; i < list[maxIndex].size(); i++) {
            bfs(list[maxIndex].get(i));
        }

        return answer;
    }

    static void bfs(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{start, --inCount[start]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == start && cur[1] == 0 && outCount[cur[0]] == 0) {
                if (list[cur[0]].isEmpty()) {
                    answer[2]++;
                } else if (pq.isEmpty()) {
                    answer[1]++;
                } else {
                    answer[3]++;
                }
                return;
            }

            for (int k = 0; k < list[cur[0]].size(); k++) {
                int next = list[cur[0]].get(k);
                outCount[cur[0]]--;
                if (--inCount[next] == 0) {
                    if (cur[0] == next) {
                        answer[1]++;
                        return;
                    }

                }
                pq.offer(new int[]{next, inCount[next]});
            }
        }
        answer[2]++;
    }
}