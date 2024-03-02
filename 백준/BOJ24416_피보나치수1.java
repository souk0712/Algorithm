import java.util.Scanner;

public class BOJ24416_피보나치수1 {

	private static int[] dp;
	private static int N;
	private static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		fib(N);
		System.out.print(cnt + " " + fibonacci(N));
		System.out.println();
	}

	private static int fibonacci(int n) {
		dp[1] = 1;
		dp[2] = 1;
		int cnt = 0;
		for (int j = 3; j <= N; j++) {
			dp[j] = dp[j - 1] + dp[j - 2];
			cnt++;
		}
		return cnt;
	}

	private static int fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		cnt++;
		return fib(n - 1) + fib(n - 2);
	}
}
