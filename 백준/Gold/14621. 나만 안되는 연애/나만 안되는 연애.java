import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[] gender;
    static int[] parent;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gender = new char[N + 1];
        parent = new int[N + 1];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken().charAt(0);
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(to, from, cost));
        }

        System.out.println(kruskal());
    }

    private static int kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(list);
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.to) == find(cur.from) || gender[cur.to] == gender[cur.from]) continue;
            union(cur.to, cur.from);
            sum += cur.cost;
        }

        boolean check = true;
        for (int i = 1; i < parent.length - 1; i++) {
            if (find(i) != find(i + 1)) {
                check = false;
                break;
            }
        }

        if (check) {
            return sum;
        }
        return -1;
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int to, from, cost;

        Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}