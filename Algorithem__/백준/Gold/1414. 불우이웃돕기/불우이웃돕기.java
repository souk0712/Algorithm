import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int total = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    pq.offer(new Node(i, j, c - 'a' + 1));
                    total += c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    pq.offer(new Node(i, j, c - 'A' + 27));
                    total += c - 'A' + 27;
                }
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sum += cur.cost;
        }

        int p = find(0);
        for (int i = 1; i < N; i++) {
            if (p != find(i)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(total - sum);
    }

    static void union(int a, int b) {
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