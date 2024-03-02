import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, t;
    static ArrayList<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        for (int k = 0; k < list[1].size(); k++) {
            Node n = list[1].get(k);
            pq.offer(n);
        }
        visit[1] = true;

        int sum = 0;
        int success = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.from]) continue;
            visit[cur.from] = true;
            sum += (cur.cost + t * success);
            success++;

            for (int k = 0; k < list[cur.from].size(); k++) {
                Node n = list[cur.from].get(k);
                if (visit[n.from]) continue;
                pq.offer(n);
            }
        }

        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {
        int from, cost;

        Node(int from, int cost) {
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}