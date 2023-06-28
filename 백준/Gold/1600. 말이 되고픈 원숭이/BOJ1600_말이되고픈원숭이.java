import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {

    static int K, W, H, min;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static Position start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = new Position(0, 0, K, 0);
        end = new Position(H - 1, W - 1, K, 0);

        bfs();

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y][start.k] = true;

        while (!q.isEmpty()) {
            Position cur = q.poll();

            if (cur.x == end.x && cur.y == end.y) {
                min = Math.min(cur.cnt, min);
            }

            // 일반 이동
            for (int k = 0; k < dx.length; k++) {
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];
                if (x < 0 || y < 0 || x >= H || y >= W) continue;
                if (visited[x][y][cur.k] || map[x][y] == 1) continue;
                q.add(new Position(x, y, cur.k, cur.cnt + 1));
                visited[x][y][cur.k] = true;
            }

            // 말 이동
            if (cur.k > 0) {
                for (int k = 0; k < hx.length; k++) {
                    int x = cur.x + hx[k];
                    int y = cur.y + hy[k];
                    int mk = cur.k - 1;
                    if (x < 0 || y < 0 || x >= H || y >= W) continue;
                    if (visited[x][y][mk] || map[x][y] == 1) continue;
                    q.add(new Position(x, y, mk, cur.cnt + 1));
                    visited[x][y][mk] = true;
                }
            }
        }
    }

    static class Position {
        int x, y, k, cnt;

        Position(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}