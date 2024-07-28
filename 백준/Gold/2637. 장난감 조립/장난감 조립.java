import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] in = new int[N + 1];
        int[] ans = new int[N + 1];
        ArrayList<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, k));
            d[y]++;
            in[x]++;
        }
        ans[N] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int k = 0; k < list[cur.next].size(); k++) {
                Node node = list[cur.next].get(k);
                if(--d[node.next] == 0){
                    pq.add(new Node(node.next, d[node.next]));
                }
                ans[node.next] += ans[cur.next] * node.cost;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                System.out.println(i + " " + ans[i]);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost,o.cost);
        }
    }
}