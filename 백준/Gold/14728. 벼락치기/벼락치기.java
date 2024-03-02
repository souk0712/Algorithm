import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][T + 1];
        int[][] list = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            list[i][0] = K;
            list[i][1] = S;
        }

        for (int j = 1; j <= N; j++) {
            int[] cur = list[j - 1];
            for (int i = 1; i <= T; i++) {
                if (i >= cur[0]) {
                    dp[j][i] = Math.max(dp[j - 1][i - cur[0]] + cur[1], dp[j - 1][i]);
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}