import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[1_000_001][2];
        long MOD = 1_000_000_007;

        dp[0][0] = 0;
        dp[1][0] = 2;
        dp[2][0] = 7;
        dp[2][1] = 1;

        for (int i = 3; i < 1_000_001; i++) {
            dp[i][1] = (dp[i - 1][1] + dp[i - 3][0]) % MOD;
            dp[i][0] = (2 * dp[i - 1][0] + 3 * dp[i - 2][0] + 2 * dp[i][1]) % MOD;
        }
        System.out.println(dp[N][0]);
    }
}