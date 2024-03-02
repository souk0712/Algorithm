import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static Deque<FireBall>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Deque[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayDeque<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].offer(new FireBall(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            move();
            joinFireBall();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Deque<FireBall> dq = map[i][j];
                while (!dq.isEmpty()) {
                    FireBall cur = dq.poll();
                    ans += cur.m;
                }
            }
        }

        System.out.println(ans);
    }

    private static void joinFireBall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = map[i][j].size();
                if (size <= 1) continue;
                Deque<FireBall> dq = map[i][j];
                int m = 0;
                int s = 0;
                int isOdd = 0;
                int isEven = 0;
                while (!dq.isEmpty()) {
                    FireBall cur = dq.poll();
                    m += cur.m;
                    s += cur.s;
                    if (cur.d % 2 != 0) {
                        isOdd++;
                    } else {
                        isEven++;
                    }
                }
                int mm = m / 5;
                int ms = s / size;
                if (mm == 0) {
                    continue;
                }
                if (isOdd == 0 || isEven == 0) {
                    for (int k = 0; k < dx.length; k += 2) {
                        map[i][j].offer(new FireBall(i, j, mm, ms, k));
                    }
                } else {
                    for (int k = 1; k < dx.length; k += 2) {
                        map[i][j].offer(new FireBall(i, j, mm, ms, k));
                    }
                }
            }
        }
    }

    private static void move() {
        Deque<FireBall> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!map[i][j].isEmpty()) {
                    dq.offer(map[i][j].poll());
                }
            }
        }

        while (!dq.isEmpty()) {
            FireBall cur = dq.poll();

            int mx = cur.x + dx[cur.d] * cur.s;
            int my = cur.y + dy[cur.d] * cur.s;
            while (mx < 0) {
                mx += N;
            }
            while (my < 0) {
                my += N;
            }
            mx %= N;
            my %= N;
            map[mx][my].offer(new FireBall(mx, my, cur.m, cur.s, cur.d));
        }
    }

    static class FireBall {
        int x, y, m, s, d;

        FireBall(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}