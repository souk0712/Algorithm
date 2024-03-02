import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            ans = 0;
            int[][] dp = new int[N + 4][4];

            // 초기값
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;

            for (int i = 4; i <= N; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][2] + dp[i - 2][1];
                dp[i][3] = dp[i - 3][3] + dp[i - 3][2] + dp[i - 3][1];
            }

            for (int i = 1; i < 4; i++) {
                ans += dp[N][i];
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}