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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b, c));
        }

        System.out.println(krusukal(pq));
    }

    private static int krusukal(PriorityQueue<Node> pq) {
        int res = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.a) == find(cur.b)) continue;
            if (count < N - 2) {
                union(cur.a, cur.b);
                res += cur.c;
                count++;
            }
        }

        return res;
    }

    public static void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) return;
        if (xx > yy) {
            parent[xx] = yy;
        } else {
            parent[yy] = xx;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static class Node implements Comparable<Node> {
        int a, b, c;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Node o) {
            return Integer.compare(c, o.c);
        }
    }
}