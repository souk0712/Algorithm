import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int[][] map;
    static int N, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int dir) {    //  0: 가로, 1: 세로, 2: 대각선
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }
        int rx = x + dx[0];     // 가로
        int ry = y + dy[0];     // 가로
        int dwx = x + dx[1];    // 세로
        int dwy = y + dy[1];    // 세로
        int rdx = x + dx[2];    // 대각선
        int rdy = y + dy[2];    // 대각선
        if (dir == 0) {
            // 가로
            if (rx < N && ry < N && map[rx][ry] == 0) {
                dfs(rx, ry, 0);
            }
            // 대각선
            if (rdx < N && rdy < N && map[rx][ry] == 0 && map[rdx][rdy] == 0 && map[dwx][dwy] == 0) {
                dfs(rdx, rdy, 2);
            }
        } else if (dir == 1) {
            // 세로
            if (dwx < N && dwy < N && map[dwx][dwy] == 0) {
                dfs(dwx, dwy, 1);
            }
            // 대각선
            if (rdx < N && rdy < N && map[rx][ry] == 0 && map[rdx][rdy] == 0 && map[dwx][dwy] == 0) {
                dfs(rdx, rdy, 2);
            }
        } else if (dir == 2) {
            // 가로
            if (rx < N && ry < N && map[rx][ry] == 0) {
                dfs(rx, ry, 0);
            }
            // 세로
            if (dwx < N && dwy < N && map[dwx][dwy] == 0) {
                dfs(dwx, dwy, 1);
            }
            // 대각선
            if (rdx < N && rdy < N && map[rx][ry] == 0 && map[rdx][rdy] == 0 && map[dwx][dwy] == 0) {
                dfs(rdx, rdy, 2);
            }
        }
    }
}