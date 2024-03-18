import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        int div = 10_007;
        dp[1] = 1;
        dp[2] = 3;
        // 1, 3, 5, 11, 21, ...
        //      2  6  10
        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 2] * 2) % div + dp[i - 1] % div) % div;
        }
        System.out.println(dp[N]);
    }
}