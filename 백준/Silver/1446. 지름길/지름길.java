import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, D;
    static int[] dp;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[10_001];
        dp = new int[D + 1];
        for (int i = 1; i <= D; i++) dp[i] = i;

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, length));
        }
        
        dijkstra(0);

        System.out.println(dp[D]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, dp[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int index = cur.index;
            int length = cur.length;

            if (index > D && dp[index] < length) continue;

            for (int i = 0; i < list[index].size(); i++) {
                Node n = list[index].get(i);
                if (n.index <= D) {
                    int ll = dp[index] + n.length;
                    if (ll < dp[n.index]) {
                        dp[n.index] = ll;
                        pq.offer(new Node(n.index, ll));
                    }
                }
            }

            if (index + 1 > D) continue;
            int ll = dp[index] + 1;
            if (ll <= dp[index + 1]) {
                dp[index + 1] = ll;
                pq.offer(new Node(index + 1, dp[index] + 1));
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int index, length;

        public Node(int index, int length) {
            this.index = index;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(length, o.length);
        }
    }
}