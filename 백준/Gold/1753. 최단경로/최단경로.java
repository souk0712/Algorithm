import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Node>[] graph;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(start);
        System.out.println();
    }

    private static void dijkstra(int start) {
        boolean[] visit = new boolean[V + 1];
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int curIndex = pq.poll().index;
            if (visit[curIndex]) continue;
            visit[curIndex] = true;

            for (Node next : graph[curIndex]) {
                if (dist[next.index] > dist[curIndex] + next.cost) {
                    dist[next.index] = dist[curIndex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    static class Node implements Comparable<Node> {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}