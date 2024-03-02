import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        Deque<Point> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        dq.offer(new Point(startX, startY, 0));
        visit[startX][startY] = true;

        while (!dq.isEmpty()) {
            Point cur = dq.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cnt;
            }

            for (int k = 0; k < dx.length; k++) {
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if (visit[mx][my]) continue;
                visit[mx][my] = true;
                if (map[mx][my] == 1) {
                    dq.offerLast(new Point(mx, my, cur.cnt + 1));
                } else {
                    dq.offerFirst(new Point(mx, my, cur.cnt));
                }
            }
        }
        return 0;
    }

    static class Point {
        int x, y, cnt;


        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}