import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1263_사람네트워크2 {

	private static int N;
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int res = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dp = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && dp[i][j] == 0) { // 아주 큰 비용을 할당
						dp[i][j] = 999999;
					}
				}
			}
			// 플로이드 와샬
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j) { // 출발지 도착지 무시
							continue;
						}
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += dp[i][j];
				}
				res = Math.min(res, sum);
			}
			System.out.println("#" + t + " " + res);
		}
	}

}
