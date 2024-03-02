import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int k, w, h;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[] hdx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int[][] map;

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][][] visited = new boolean[h][w][k + 1];
        q.offer(new Position(0, 0, 0, 0));
        visited[0][0][0] = true;    // x, y, k

        Position cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.x == h - 1 && cur.y == w - 1) {
                answer = cur.cnt;
                break;
            }
            // 원숭이 이동
            int nx, ny;
            for (int i = 0; i < dx.length; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visited[nx][ny][cur.k]) continue;
                if (map[nx][ny] == 1) continue;
                q.offer(new Position(nx, ny, cur.k, cur.cnt + 1));
                visited[nx][ny][cur.k] = true;
            }

            // 말 이동
            if (cur.k < k) {
                for (int i = 0; i < hdx.length; i++) {
                    nx = cur.x + hdx[i];
                    ny = cur.y + hdy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (visited[nx][ny][cur.k + 1]) continue;
                    if (map[nx][ny] == 1) continue;
                    q.offer(new Position(nx, ny, cur.k + 1, cur.cnt + 1));
                    visited[nx][ny][cur.k + 1] = true;
                }
            }
        }
    }

    static class Position {
        int x, y;
        int k;
        int cnt;

        Position(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}