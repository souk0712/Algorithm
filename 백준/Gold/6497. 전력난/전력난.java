import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;

            int sum = 0;
            graph = new ArrayList[M];
            for (int i = 0; i < M; i++) graph[i] = new ArrayList<Edge>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph[x].add(new Edge(y, z));
                graph[y].add(new Edge(x, z));
                sum += z;
            }
            sb.append(sum - prim(0, M)).append("\n");
        }
        System.out.println(sb);
    }

    private static int prim(int start, int M) {
        boolean[] visit = new boolean[M];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;
            if (visit[v]) continue;
            visit[v] = true;
            total += cost;
            for (Edge e : graph[v]) {
                if (!visit[e.w]) {
                    pq.offer(e);
                }
            }
        }
        return total;
    }

    static class Edge implements Comparable<Edge> {
        int w, cost;

        Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}