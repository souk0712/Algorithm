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
        PriorityQueue<Node> pq = new PriorityQueue<>();

        long total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(to, from, cost));
            total += cost;
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sum += cur.cost;
        }
        int p = find(1);
        for (int i = 2; i <= N; i++) {
            if (p != find(i)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total - sum);
    }

    private static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static class Node implements Comparable<Node> {
        int to, from, cost;

        Node(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}