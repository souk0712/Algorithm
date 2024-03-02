import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] parent;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y, i));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int j = 1; j < parent.length; j++) parent[j] = j;
            int res = kruskal();
            if (isAllConnection()) {
                sb.append(res).append(" ");
                list.remove(0);
            } else {
                for (int k = i; k < K; k++) {
                    sb.append(0).append(" ");
                }
                break;
            }
        }
        System.out.println(sb);
    }

    private static boolean isAllConnection() {
        for (int i = 1; i < parent.length - 1; i++) {
            if (find(parent[i]) != find(parent[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static int kruskal() {
        int sum = 0;
        for (Node n : list) {
            if (find(n.to) == find(n.from)) continue;
            union(n.to, n.from);
            sum += n.cost;
        }
        return sum;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        if (aa > bb) parent[aa] = bb;
        else parent[bb] = aa;
    }

    static class Node implements Comparable<Node> {
        int to, from, cost;

        Node(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}