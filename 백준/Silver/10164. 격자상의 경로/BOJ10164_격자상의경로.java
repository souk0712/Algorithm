import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10164_격자상의경로 {

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer;

        if (K == 0) {
            answer = calculate(M, N);
        } else {
            int topWidth = K % M == 0 ? M : K % M;
            int bottomWidth = M - (K % M == 0 ? M : K % M) + 1;
            int topHeight = K % M == 0 ? K / M : K / M + 1;
            int bottomHeight = K % M == 0 ? N - K / M + 1 : N - K / M;

            int top = calculate(topWidth, topHeight);
            int bottom = calculate(bottomWidth, bottomHeight);
            answer = top * bottom;
        }

        System.out.println(answer == 0 ? 1 : answer);
    }

    private static int calculate(int width, int height) {
        int[][] dp = new int[height][width];

        dp[0][0] = 0;

        for (int i = 1; i < width; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < height; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[height - 1][width - 1];
    }
}