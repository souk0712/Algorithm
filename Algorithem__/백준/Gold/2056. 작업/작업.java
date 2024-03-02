import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] time = new int[N + 1];

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i < list.length; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            d[i] = num;
            time[i] = t;
            for (int j = 0; j < num; j++) {
                int n = Integer.parseInt(st.nextToken());
                list[n].add(i);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] == 0) {
                pq.offer(new int[]{i, time[i]});
            }
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int k = 0; k < list[cur[0]].size(); k++) {
                int n = list[cur[0]].get(k);
                if (--d[n] == 0) {
                    pq.offer(new int[]{n, cur[1] + time[n]});
                }
            }
            if (pq.isEmpty()) {
                sum = cur[1];
            }
        }
        System.out.println(sum);
    }
}