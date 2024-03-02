import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            union(to, from);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i == 1 || j == 1 || i == j) continue;
                pq.offer(new Edge(i, j, value));
            }
        }

        kruskal(pq);
        System.out.println(sb);
    }

    private static void kruskal(PriorityQueue<Edge> pq) {
        int sum = 0;
        int count = 0;

        sb.append("\n");
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.to, cur.from)) {
                sum += cur.cost;
                count++;
                sb.append(cur.to).append(" ").append(cur.from).append("\n");
            }
        }
        sb.insert(0, count).insert(0, " ").insert(0, sum);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return false;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
        return true;
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