import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;
    static Pos red, blue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    red = new Pos(i, j);
                } else if (map[i][j] == 'B') {
                    blue = new Pos(i, j);
                }
            }
        }

        Deque<Marble> dq = new ArrayDeque<>();
        dq.offer(new Marble(red, blue, 0));

        while (!dq.isEmpty()) {
            Marble cur = dq.poll();
            if (cur.cnt > 10) {
                break;
            }
            if (map[cur.blue.x][cur.blue.y] == 'O') {
                continue;
            }
            if (map[cur.red.x][cur.red.y] == 'O') {
                System.out.println(1);
                return;
            }

            for (int k = 0; k < dx.length; k++) {
                int r = cur.red.x * dx[k] + cur.red.y * dy[k];
                int b = cur.blue.x * dx[k] + cur.blue.y * dy[k];
                Pos mRed, mBlue;
                if (r > b) {
                    mRed = move(cur.red.x, cur.red.y, k);
                    mBlue = move(cur.blue.x, cur.blue.y, k);
                    if (map[mRed.x][mRed.y] != 'O' && mRed.x == mBlue.x && mRed.y == mBlue.y) {
                        mBlue = new Pos(mBlue.x - dx[k], mBlue.y - dy[k]);
                    }
                } else {
                    mBlue = move(cur.blue.x, cur.blue.y, k);
                    mRed = move(cur.red.x, cur.red.y, k);
                    if (map[mRed.x][mRed.y] != 'O' && mRed.x == mBlue.x && mRed.y == mBlue.y) {
                        mRed = new Pos(mRed.x - dx[k], mRed.y - dy[k]);
                    }
                }
                dq.offer(new Marble(mRed, mBlue, cur.cnt + 1));
            }
        }
        System.out.println(0);
    }

    private static Pos move(int i, int j, int k) {
        while (true) {
            int mx = i + dx[k];
            int my = j + dy[k];
            if (map[mx][my] == '#') break;
            i = mx;
            j = my;
            if (map[mx][my] == 'O') break;
        }
        return new Pos(i, j);
    }

    static class Marble {
        Pos red, blue;
        int cnt;

        Marble(Pos red, Pos blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}