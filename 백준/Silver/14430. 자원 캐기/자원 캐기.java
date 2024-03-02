import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 줄
        dp[0][0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        // 두번째 ~ 마지막 줄
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];

            for (int j = 1; j < M; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + map[i][j];
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}