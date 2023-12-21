import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 0; i < K; i++) {
            int m = Integer.parseInt(st.nextToken());
            parent[m] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(u, v, w));
        }

        System.out.println(kruskal(pq));
    }

    private static int kruskal(PriorityQueue<Node> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.u) == find(cur.v)) continue;
            union(cur.u, cur.v);
            sum += cur.w;
        }
        return sum;
    }

    static int find(int x) {
        if (parent[x] == -1) return -1;
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) return;

        if (xx > yy) parent[xx] = yy;
        else parent[yy] = xx;
    }

    static class Node implements Comparable<Node> {
        int u, v, w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(w, o.w);
        }
    }
}