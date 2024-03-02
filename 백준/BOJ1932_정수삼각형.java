import java.util.Scanner;

public class BOJ1932_정수삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] input = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		dp[1][1] = input[1][1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j] + input[i][j], dp[i - 1][j - 1] + input[i][j]);
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(dp[N][i], max);
		}
		System.out.println(max);
	}

}
