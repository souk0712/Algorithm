import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 3001;
            }
        }
        for (int j = 0; j < 3; j++) {
            dp[0][j] = map[0][j];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + map[i][2];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(dp[N - 1][i], ans);
        }
        System.out.println(ans);
    }
}