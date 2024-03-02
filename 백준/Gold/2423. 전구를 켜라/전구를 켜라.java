import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[][] map;
    static int[][] dist;
    private static final int INF = 250001;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] hx = {-1, 1, 1, -1};
    static int[] hy = {1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '\\') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        boolean check;
        if (map[0][0] == 0) {
            map[0][0] = 1;
            check = dijkstra(1);
        } else {
            check = dijkstra(0);
        }
        if (check) {
            System.out.println(dist[N - 1][M - 1]);
        } else {
            System.out.println("NO SOLUTION");
        }
    }

    private static boolean dijkstra(int init) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][M];
        dist = new int[N][M];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        dist[0][0] = init;
        visit[0][0] = true;
        pq.offer(new Point(0, 0, map[0][0], dist[0][0]));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.x == N - 1 && cur.y == M - 1 && cur.d == 1) {
                return true;
            }

            for (int k = 0; k < dx.length; k++) {
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if (visit[mx][my]) continue;
                if (map[mx][my] != cur.d) {
                    if (dist[mx][my] > dist[cur.x][cur.y]) {
                        dist[mx][my] = dist[cur.x][cur.y];
                        visit[mx][my] = true;
                        pq.offer(new Point(mx, my, map[mx][my], dist[mx][my]));
                    }
                } else {
                    if (dist[mx][my] > dist[cur.x][cur.y] + 1) {
                        dist[mx][my] = dist[cur.x][cur.y] + 1;
                        visit[mx][my] = true;
                        pq.offer(new Point(mx, my, 1 - map[mx][my], dist[mx][my]));
                    }
                }

            }
            for (int k = 0; k < hx.length; k++) {
                int mx = cur.x + hx[k];
                int my = cur.y + hy[k];
                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if (visit[mx][my]) continue;
                if (k % 2 != cur.d) continue;
                if (map[mx][my] == cur.d) {
                    if (dist[mx][my] > dist[cur.x][cur.y]) {
                        dist[mx][my] = dist[cur.x][cur.y];
                        visit[mx][my] = true;
                        pq.offer(new Point(mx, my, map[mx][my], dist[mx][my]));
                    }
                } else {
                    if (dist[mx][my] > dist[cur.x][cur.y] + 1) {
                        dist[mx][my] = dist[cur.x][cur.y] + 1;
                        visit[mx][my] = true;
                        pq.offer(new Point(mx, my, 1 - map[mx][my], dist[mx][my]));
                    }
                }
            }
        }
        return false;
    }

    static class Point implements Comparable<Point> {
        int x, y, d, cnt;

        Point(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(cnt, o.cnt);
        }
    }
}