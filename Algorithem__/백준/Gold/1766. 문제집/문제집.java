import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        int[] d = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            d[B]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int c = Integer.compare(o1[1], o2[1]);
            if (c == 0) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return c;
            }
        });
        for (int i = 1; i <= N; i++) {
            if (d[i] == 0) {
                pq.offer(new int[]{i, 0});
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visit[cur[0]]) continue;
            visit[cur[0]] = true;
            if (cur[1] == 0) {
                sb.append(cur[0]).append(" ");
            }
            for (int k = 0; k < list[cur[0]].size(); k++) {
                int next = list[cur[0]].get(k);

                d[next]--;
                pq.offer(new int[]{next, d[next]});
            }
        }
        System.out.println(sb);
    }
}