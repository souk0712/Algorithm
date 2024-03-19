import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(move(0, 0));
    }

    private static int move(int i, int j) {
        if (i == M - 1 && j == N - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        for (int k = 0; k < dx.length; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];
            if (mx < 0 || my < 0 || mx >= M || my >= N) continue;
            if (map[i][j] <= map[mx][my]) continue;
            res += move(mx, my);
        }

        return dp[i][j] = res;
    }
}