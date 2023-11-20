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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        long total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
            total += c;
        }
        long ans = kruskal(pq);
        if (isCheckAllPath()) {
            System.out.println(total - ans);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isCheckAllPath() {
        int compare = find(1);
        for (int i = 2; i <= N; i++) {
            if (compare != find(i)) return false;
        }
        return true;
    }

    private static long kruskal(PriorityQueue<Node> pq) {
        long sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.a) == find(cur.b)) continue;
            union(cur.a, cur.b);
            sum += cur.c;
        }
        return sum;
    }

    static void union(int a, int b) {
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