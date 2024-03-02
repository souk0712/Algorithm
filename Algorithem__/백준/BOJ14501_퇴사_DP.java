package algo_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501_퇴사_DP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N];
		int[] p = new int[N];
		int[] dp = new int[N + 1];
		StringTokenizer st;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			t[n] = Integer.parseInt(st.nextToken());
			p[n] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (i + t[i] <= N) { 
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
		}
		System.out.println(dp[N]);
	}
}
