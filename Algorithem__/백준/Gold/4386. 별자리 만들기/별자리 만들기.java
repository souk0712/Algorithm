import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<double[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new double[]{x, y});
        }

        for (int i = 0; i < N; i++) {
            double[] to = list.get(i);
            for (int j = 0; j < N; j++) {
                double[] from = list.get(j);
                double dist = Math.sqrt(Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
                pq.offer(new Edge(i, j, dist));
            }
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (union(cur.to, cur.from)) {
                sum += cur.cost;
            }
        }

        System.out.printf("%.2f", sum);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return false;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
        return true;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int to, from;
        double cost;

        Edge(int to, int from, double cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(cost, o.cost);
        }
    }
}