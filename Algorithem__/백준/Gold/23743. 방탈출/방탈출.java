import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(0, i, t));
        }

        System.out.println(kruskal(pq));
    }

    private static int kruskal(PriorityQueue<Edge> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.to, cur.from)) {
                sum += cur.cost;
            }
        }
        return sum;
    }

    private static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return false;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
        return true;
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