import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dist;
    static ArrayList<Pos>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        Arrays.fill(dist, 100_000_001);
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[to].add(new Pos(from, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        dist[start] = 0;
        pq.offer(new Pos(start, dist[start]));

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            if (visit[cur.next]) continue;
            visit[cur.next] = true;

            for (int k = 0; k < list[cur.next].size(); k++) {
                Pos n = list[cur.next].get(k);
                if (visit[n.next]) continue;
                if (dist[n.next] > dist[cur.next] + n.cost) {
                    dist[n.next] = dist[cur.next] + n.cost;
                    pq.offer(new Pos(n.next, dist[n.next]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Pos implements Comparable<Pos> {
        int next, cost;

        Pos(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(cost, o.cost);
        }
    }
}