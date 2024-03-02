import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][10001];
        for (int m = 1; m < N + 1; m++) {
            int[] cur = arr[m - 1];
            for (int c = 0; c < 10001; c++) {
                if (c == 0 && cur[1] == 0) {
                    dp[m][c] = cur[0] + dp[m - 1][c];
                    continue;
                }
                if (c >= cur[1]) {
                    dp[m][c] = Math.max(dp[m - 1][c], dp[m - 1][c - cur[1]] + cur[0]);
                } else {
                    dp[m][c] = dp[m - 1][c];
                }

            }
        }

        int ans = 10001;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < 10001; j++) {
                if (dp[i][j] >= M) {
                    ans = Math.min(j, ans);
                }
            }
        }
        System.out.println(ans);
    }
}