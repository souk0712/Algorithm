import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리_Prim {

    static int v;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        System.out.println(prim());
    }

    private static long prim() {
        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long weight = 0;

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.w]) continue;
            weight += cur.cost;
            visit[cur.w] = true;

            for (int i = 0; i < list[cur.w].size(); i++) {
                Node next = list[cur.w].get(i);
                if (visit[next.w]) continue;
                pq.offer(next);
            }
        }

        return weight;
    }

    public static class Node implements Comparable<Node> {
        int w, cost;

        Node(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}