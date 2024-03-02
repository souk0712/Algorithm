import java.util.Scanner;

public class BOJ1904_01타일 {
	static final int MOD = 15746;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
		}

		System.out.println(dp[N]);
	}
}
