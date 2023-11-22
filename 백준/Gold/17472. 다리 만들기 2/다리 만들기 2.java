import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static Set<Edge> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    map[i][j] = -1;
                    continue;
                }
                map[i][j] = num;
            }
        }

        int index = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) continue;
                labeling(i, j, index);
                index++;
            }
        }
        parent = new int[index];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                buildBridge(i, j);
            }
        }

        pq = new PriorityQueue<>(set);
        int ans = kruskal();
        System.out.println(checkAllPath() ? ans : -1);
    }

    private static boolean checkAllPath() {
        int compare = find(1);
        for (int i = 2; i < parent.length; i++) {
            int cur = find(i);
            if (compare != cur) return false;
        }
        return true;
    }

    private static int kruskal() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.to) == find(cur.from)) continue;
            union(cur.to, cur.from);
            sum += cur.cost;
        }
        return sum;
    }

    private static void buildBridge(int i, int j) {
        for (int k = 0; k < dx.length; k++) {
            straightPath(i, j, k, map[i][j], 0);
        }
    }

    private static void straightPath(int i, int j, int k, int index, int cnt) {
        int mx = i + dx[k];
        int my = j + dy[k];
        if (checkRange(mx, my)) {
            if (map[mx][my] == 0) {
                straightPath(i + dx[k], j + dy[k], k, index, cnt + 1);
            } else if (map[mx][my] != index) {
                if (cnt > 1)
                    set.add(new Edge(index, map[mx][my], cnt));
            }
        }

    }

    public static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa > bb) parent[aa] = bb;
        else parent[bb] = aa;
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void labeling(int startX, int startY, int index) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new Position(startX, startY));
        visit[startX][startY] = true;
        map[startX][startY] = index;
        while (!q.isEmpty()) {
            Position p = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = p.x + dx[k];
                int my = p.y + dy[k];
                if (checkRange(mx, my) && !visit[mx][my] && map[mx][my] == -1) {
                    map[mx][my] = index;
                    q.offer(new Position(mx, my));
                    visit[mx][my] = true;
                }
            }
        }
    }

    private static boolean checkRange(int mx, int my) {
        return mx >= 0 && my >= 0 && mx < N && my < M;
    }

    public static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Edge) {
                Edge tmp = (Edge) o;
                return ((this.to == tmp.to && this.from == tmp.from) || (this.to == tmp.from && this.from == tmp.to)) && this.cost == tmp.cost;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost);
        }
    }
}