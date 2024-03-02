import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[2][n];
            int[][] dp = new int[2][n + 2];
            for (int j = 0; j < 2; j++) {
                String[] s = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    map[j][i] = Integer.parseInt(s[i]);
                    dp[j][i + 2] = Integer.parseInt(s[i]);
                }
            }
            // 0이면 [1][i-1],[1][i-2]
            // 1이면 [0][i-1],[0][i-2]
            for (int i = 2; i < n + 2; i++) {
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
            }
            int res = Math.max(dp[1][n + 1], dp[0][n + 1]);
            System.out.println(res);
        }
    }
}
