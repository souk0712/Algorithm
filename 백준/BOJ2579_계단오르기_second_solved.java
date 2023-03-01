import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 계단 개수
        int[] score = new int[301];
        int[] dp = new int[301];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        dp[2] = Math.max(score[0], score[1]) + score[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(score[i - 1] + dp[i - 3], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n - 1]);
    }
}
