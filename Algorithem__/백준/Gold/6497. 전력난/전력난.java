import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            parent = new int[M];
            for (int i = 0; i < M; i++) parent[i] = i;
            int total = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                total += z;
                pq.offer(new Node(x, y, z));
            }
            sb.append(total - kruskal(pq)).append("\n");
        }
        System.out.println(sb);
    }

    private static int kruskal(PriorityQueue<Node> pq) {
        int min = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.v) == find(cur.w)) continue;
            union(cur.v, cur.w);
            min += cur.cost;
        }
        return min;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static class Node implements Comparable<Node> {
        int v, w, cost;

        Node(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}