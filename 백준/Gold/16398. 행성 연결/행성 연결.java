import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        PriorityQueue<Planet> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                pq.offer(new Planet(i, j, cost));
            }
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            Planet cur = pq.poll();
            if (union(cur.to, cur.from)) {
                sum += cur.cost;
            }
        }
        System.out.println(sum);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return false;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
        return true;
    }

    static class Planet implements Comparable<Planet> {
        int to, from, cost;

        Planet(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Planet o) {
            return Integer.compare(cost, o.cost);
        }
    }
}