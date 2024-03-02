import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        System.out.println(comb(N, K));
    }

    private static int comb(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return 1;
        }

        return dp[n][k] = comb(n - 1, k - 1) + comb(n - 1, k);
    }
}