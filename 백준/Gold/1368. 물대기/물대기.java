import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] W, parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (i == j) {
                    pq.offer(new Node(0, i, W[i]));
                } else if (i > j) {
                    pq.offer(new Node(i, j, input));
                }
            }
        }

        System.out.println(kruskal(pq));
    }

    private static int kruskal(PriorityQueue<Node> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sum += cur.cost;
        }
        return sum;
    }

    static int find(int x) {
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