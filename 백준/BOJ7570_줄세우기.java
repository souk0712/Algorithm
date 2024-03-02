import java.util.Scanner;

public class BOJ7570_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		int max = 0;

		for (int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			dp[k] = dp[k - 1] + 1;
			max = Math.max(dp[k], max);
		}

		System.out.println(N - max);
	}

}
