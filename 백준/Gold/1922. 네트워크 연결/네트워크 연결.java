import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<Node>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[to].add(new Node(from, cost));
            list[from].add(new Node(to, cost));
        }

        System.out.println(prim(1));
    }

    private static long prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        pq.offer(new Node(start, 0));

        long sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.next]) continue;
            visit[cur.next] = true;
            sum += cur.cost;

            for (int i = 0; i < list[cur.next].size(); i++) {
                Node n = list[cur.next].get(i);
                if (visit[n.next]) continue;
                pq.offer(n);
            }
        }
        return sum;
    }

    static class Node implements Comparable<Node> {
        int next, cost;

        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}