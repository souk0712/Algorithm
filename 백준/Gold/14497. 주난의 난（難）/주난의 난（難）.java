import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static char[][] map;
    static int sx, sy, ex, ey;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new int[]{sx, sy, 0});
        visit[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey) {
                return cur[2];
            }
            for (int k = 0; k < dx.length; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;

                if (visit[mx][my]) continue;
                visit[mx][my] = true;

                if (map[mx][my] == '0') {
                    q.offerFirst(new int[]{mx, my, cur[2]});
                } else {
                    map[mx][my] = '0';
                    q.offerLast(new int[]{mx, my, cur[2] + 1});
                }
            }
        }
        return 0;
    }
}