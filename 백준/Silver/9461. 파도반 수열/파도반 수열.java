import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}