import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, X;
    static ArrayList<Node>[] list;
    static int[] dist, total;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        total = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            total[i] = dist[X];
        }
        dijkstra(X);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i] + total[i]);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.dest]) continue;
            visit[cur.dest] = true;

            for (Node next : list[cur.dest]) {
                if (dist[next.dest] > dist[cur.dest] + next.cost) {
                    dist[next.dest] = dist[cur.dest] + next.cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int dest, cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}