import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, K, max, startNode;
    static int[] parent;
    static ArrayList<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
        parent = new int[N];
        for (int i = 1; i < N; i++) parent[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }

        int min = kruskal(pq);
        max = Integer.MIN_VALUE;
        boolean[] visit = new boolean[N];
        visit[0] = true;
        dfs(visit, 0, 0);

        max = Integer.MIN_VALUE;
        visit = new boolean[N];
        visit[startNode] = true;
        dfs(visit, startNode, 0);

        System.out.println(min);
        System.out.println(max);
    }

    private static void dfs(boolean[] visit, int node, int count) {
        if (max < count) {
            max = count;
            startNode = node;
        }

        for (int i = 0; i < list[node].size(); i++) {
            Edge n = list[node].get(i);
            if (visit[n.to]) continue;
            visit[n.to] = true;
            dfs(visit, n.to, count + n.cost);
        }
    }

    private static int kruskal(PriorityQueue<Edge> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.to, cur.from)) {
                sum += cur.cost;
                list[cur.to].add(new Edge(cur.from, cur.cost));
                list[cur.from].add(new Edge(cur.to, cur.cost));
            }
        }

        return sum;
    }

    private static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return false;
        if (aa < bb) parent[bb] = aa;
        else parent[aa] = bb;
        return true;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static class Edge {
        int to, from, cost;

        Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}