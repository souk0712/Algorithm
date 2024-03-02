import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, curX, curY, ans;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] sdx = {{-1, 1, -2, 2, 0, -1, 1, -1, 1}, {0, 0, 1, 1, 3, 1, 1, 2, 2}, {-1, 1, -2, 2, 0, 1, -1, 1, -1}, {0, 0, -1, -1, -3, -1, -1, -2, -2}};
    static int[][] sdy = {{0, 0, -1, -1, -3, -1, -1, -2, -2}, {-1, 1, -2, 2, 0, -1, 1, -1, 1}, {0, 0, 1, 1, 3, 1, 1, 2, 2}, {-1, 1, -2, 2, 0, -1, 1, -1, 1}};
    static float[] rate = {0.01f, 0.01f, 0.02f, 0.02f, 0.05f, 0.07f, 0.07f, 0.1f, 0.1f};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        curX = N / 2;
        curY = N / 2;
        int dir = 0;
        int length = 1;
        while (length < N) {
            for (int i = 0; i < length; i++) {
                move(dir % 4);
            }
            dir++;
            for (int i = 0; i < length; i++) {
                move(dir % 4);
            }
            dir++;
            length++;
        }
        
        for (int i = 0; i < length; i++) {
            move(dir % 4);
        }

        System.out.println(ans);
    }

    private static void move(int dir) {
        int mx = curX + dx[dir];
        int my = curY + dy[dir];
        if (mx < 0 || my < 0 || mx >= N || my >= N) return;
        spread(mx, my, dir);
        curX = mx;
        curY = my;
    }

    private static void spread(int x, int y, int dir) {
        int total = map[x][y];
        map[x][y] = 0;

        int sum = 0;
        for (int i = 0; i < sdx[dir].length; i++) {
            int mx = curX + sdx[dir][i];
            int my = curY + sdy[dir][i];
            int sand = (int) (rate[i] * total);
            sum += sand;
            if (mx < 0 || my < 0 || mx >= N || my >= N) {
                ans += sand;
                continue;
            }
            map[mx][my] += sand;
        }

        int ax = x + dx[dir];
        int ay = y + dy[dir];
        if (ax < 0 || ay < 0 || ax >= N || ay >= N) {
            ans += (total - sum);
        } else {
            map[ax][ay] += (total - sum);
        }
    }
}