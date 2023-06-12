import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);

            graph[u].add(new Node(v, w));
        }

        Dijkstra(V, K);
    }

    private static void Dijkstra(int v, int k) {
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().index;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node next : graph[cur]) {
                if (dist[next.index] > dist[cur] + next.cost) {
                    dist[next.index] = dist[cur] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
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
            return Integer.compare(this.cost, o.cost);
        }
    }
}