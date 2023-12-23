import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1][N + 1];
            System.out.println(putBridge(M, N));
        }
    }

    private static int putBridge(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = putBridge(n - 1, k - 1) + putBridge(n - 1, k);
    }
}