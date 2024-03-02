import java.util.Scanner;

public class BOJ1912_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = sc.nextInt();
		}

		int max = dp[1];
		for (int i = 2; i <= N; i++) {
			if (dp[i - 1] > 0 && dp[i] + dp[i - 1] > 0)
				dp[i] = dp[i - 1] + dp[i];

			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);

	}

}
