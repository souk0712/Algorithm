import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static ArrayList<int[]> planets;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        planets = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            planets.add(new int[]{i, a, b, c});
        }

        System.out.println(kruskal(init()));
    }

    private static PriorityQueue<Edge> init() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            planets.sort(((o1, o2) -> Integer.compare(o1[finalI], o2[finalI])));
            for (int j = 1; j < N; j++) {
                int[] p1 = planets.get(j - 1);
                int[] p2 = planets.get(j);
                int diff = Math.abs(p1[i] - p2[i]);
                pq.add(new Edge(p1[0], p2[0], diff));
            }
        }
        return pq;
    }

    private static int kruskal(PriorityQueue<Edge> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge n = pq.poll();
            if (find(n.to) != find(n.from)) {
                union(n.to, n.from);
                sum += n.cost;
            }
        }
        return sum;
    }

    private static void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) return;
        if (xx > yy) parent[xx] = yy;
        else parent[yy] = xx;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<Edge> {
        int to, from, cost;

        Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}