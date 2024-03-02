import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        union = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            union[i] = i;
        }

        for (int i = 0; i < e; i++) {
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

            if (Find(cur.v) == Find(cur.w)) continue;
            Union(cur.v, cur.w);
            res += cur.cost;
        }

        return res;
    }


    private static void Union(int x, int y) {
        int a = Find(x);
        int b = Find(y);

        if (a == b) return;

        if (a > b) union[a] = b;
        else union[b] = a;
    }

    private static int Find(int x) {
        if (x == union[x]) return x;
        return union[x] = Find(union[x]);
    }

    public static class Node implements Comparable<Node> {
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