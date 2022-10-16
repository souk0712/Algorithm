import java.util.Scanner;

public class BOJ9461_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[] dp = new long[100];

			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;
			dp[4] = 2;

			for (int i = 5; i < 100; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[N - 1]);
		}
	}
}
