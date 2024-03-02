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

        PriorityQueue<Node> min = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        PriorityQueue<Node> max = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost, o1.cost));
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c == 1) {
                min.offer(new Node(a, b, 0));
                max.offer(new Node(a, b, 0));
            } else {
                min.offer(new Node(a, b, 1));
                max.offer(new Node(a, b, 1));
            }
        }
        for (int i = 0; i <= N; i++) parent[i] = i;

        int sumMin = 0;
        while (!min.isEmpty()) {
            Node cur = min.poll();

            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sumMin += cur.cost;
        }

        for (int i = 0; i <= N; i++) parent[i] = i;
        int sumMax = 0;

        while (!max.isEmpty()) {
            Node cur = max.poll();

            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sumMax += cur.cost;
        }

        System.out.println(sumMax * sumMax - sumMin * sumMin);
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

    static class Node {
        int to, from, cost;

        Node(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
}