import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Edge> pq;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        pq = new PriorityQueue<Edge>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[N][M];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] || map[i][j] == 0) continue;
                separateIsland(visit, --index, i, j);
            }
        }
        int count = -index;
        parent = new int[count + 1];
        for (int i = 1; i < parent.length; i++) parent[i] = i;

        if (count == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 0) continue;
                for (int k = 0; k < dx.length; k++) {
                    addPath(i, j, k, 0, map[i][j]);
                }
            }
        }

        int ans = kruskal();
        int compare = find(parent[1]);
        for (int i = 1; i < parent.length; i++) {
            if (compare != find(parent[i])) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }

    private static int kruskal() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.to, cur.from)) {
                sum += cur.cost;
            }
        }
        return sum;
    }

    private static void addPath(int i, int j, int k, int count, int index) {
        int mx = i + dx[k];
        int my = j + dy[k];
        if (checkRange(mx, my)) return;
        if (map[mx][my] == 0) {
            addPath(mx, my, k, count + 1, index);
        } else if (map[mx][my] != index) {
            if (count > 1) {
                pq.offer(new Edge(-index, -map[mx][my], count));
            }
        }
    }

    private static void separateIsland(boolean[][] visit, int index, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        map[i][j] = index;
        visit[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (checkRange(mx, my)) continue;
                if (visit[mx][my] || map[mx][my] != 1) continue;
                map[mx][my] = index;
                q.offer(new int[]{mx, my});
                visit[mx][my] = true;
            }
        }
    }

    private static boolean checkRange(int mx, int my) {
        return mx < 0 || my < 0 || mx >= N || my >= M;
    }

    static boolean union(int a, int b) {
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