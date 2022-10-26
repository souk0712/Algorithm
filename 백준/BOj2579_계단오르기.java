import java.util.Arrays;
import java.util.Scanner;

public class BOj2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] input = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}

		dp[1] = input[1];
		if (N >= 2)
			dp[2] = input[2] + input[1];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + input[i - 1] + input[i], dp[i - 2] + input[i]);
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
