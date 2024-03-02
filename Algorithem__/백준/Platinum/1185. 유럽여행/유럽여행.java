import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, P;
    static int[] visitCost;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int minVisitCost = Integer.MAX_VALUE;
        visitCost = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visitCost[i] = Integer.parseInt(br.readLine());
            minVisitCost = Math.min(minVisitCost, visitCost[i]);
        }

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[to].add(new Node(from, cost * 2 + visitCost[from] + visitCost[to]));
            list[from].add(new Node(to, cost * 2 + visitCost[from] + visitCost[to]));
        }

        System.out.println(prim(1) + minVisitCost);
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        pq.offer(new Node(start, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.from]) continue;
            visit[cur.from] = true;
            sum += cur.cost;
            for (int i = 0; i < list[cur.from].size(); i++) {
                Node n = list[cur.from].get(i);
                if (visit[n.from]) continue;
                pq.offer(n);
            }
        }
        return sum;
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