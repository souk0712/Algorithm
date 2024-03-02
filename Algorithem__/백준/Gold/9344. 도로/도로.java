import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M, P, Q;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                pq.offer(new Edge(to, from, cost));
            }

            boolean check = false;
            while (!pq.isEmpty()) {
                Edge cur = pq.poll();

                if (find(cur.to) == find(cur.from)) continue;
                if ((cur.to == P && cur.from == Q) || (cur.from == P && cur.to == Q)) {
                    check = true;
                }
                union(cur.to, cur.from);
            }

            if (check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        if (aa > bb) parent[aa] = bb;
        else parent[bb] = aa;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int to, from, cost;

        Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}