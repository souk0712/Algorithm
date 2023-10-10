import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b, c));
        }

        System.out.println(kruskal(pq));
    }

    private static int kruskal(PriorityQueue<Node> pq) {
        int res = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.a) == find(cur.b)) continue;
            union(cur.a, cur.b);
            res += cur.c;
        }
        return res;
    }

    private static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa == bb) return;
        if (aa > bb) {
            parent[aa] = bb;
        } else {
            parent[bb] = aa;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }


    public static class Node implements Comparable<Node> {
        int a, b, c;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(c, o.c);
        }
    }
}