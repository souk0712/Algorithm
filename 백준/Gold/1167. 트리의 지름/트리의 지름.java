import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, max, startNode;
    static ArrayList<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[v].add(new Node(to, cost));
            }
        }
        
        max = Integer.MIN_VALUE;
        visit = new boolean[V + 1];
        visit[1] = true;
        dfs(1, 0);

        max = Integer.MIN_VALUE;
        visit = new boolean[V + 1];
        visit[startNode] = true;
        dfs(startNode, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int total) {
        if (max < total) {
            max = total;
            startNode = node;
        }

        for (int i = 0; i < list[node].size(); i++) {
            Node n = list[node].get(i);
            if (visit[n.from]) continue;
            visit[n.from] = true;
            dfs(n.from, total + n.cost);
        }
    }

    static class Node {
        int from, cost;

        Node(int from, int cost) {
            this.from = from;
            this.cost = cost;
        }
    }
}