import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    static Fish jaws;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    jaws = new Fish(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            int res = bfs();
            if (res == -1) {
                break;
            }
            time += res;
        }
        System.out.println(time);
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) return false;
            }
        }
        return true;
    }

    private static int bfs() {
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Fish> dq = new PriorityQueue<>();
        dq.offer(new Fish(jaws.x, jaws.y, jaws.size, 0));
        visit[jaws.x][jaws.y] = true;
        while (!dq.isEmpty()) {
            Fish cur = dq.poll();
            if (cur.size != 0 && jaws.size > cur.size) {
                map[cur.x][cur.y] = 0;
                if (jaws.size == jaws.dist + 1) {
                    jaws = new Fish(cur.x, cur.y, jaws.size + 1, 0);
                } else {
                    jaws = new Fish(cur.x, cur.y, jaws.size, jaws.dist + 1);
                }
                return cur.dist;
            }

            for (int k = 0; k < 4; k++) {
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if (mx < 0 || mx >= N || my < 0 || my >= N) continue;
                if (visit[mx][my] || map[mx][my] > jaws.size) continue;
                visit[mx][my] = true;
                dq.offer(new Fish(mx, my, map[mx][my], cur.dist + 1));
            }
        }
        return -1;
    }

    static class Fish implements Comparable<Fish> {
        int x, y, size, dist;

        Fish(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            int c = Integer.compare(dist, o.dist);
            if (c == 0) {
                int cc = Integer.compare(x, o.x);
                if (cc == 0) {
                    return Integer.compare(y, o.y);
                } else {
                    return cc;
                }
            } else {
                return c;
            }
        }
    }
}