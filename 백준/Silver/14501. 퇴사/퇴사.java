import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[][] map = new int[N][2];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            // 일을 했을 경우
            if (i + map[i][0] <= N) {
                dp[i + map[i][0]] = Math.max(dp[i + map[i][0]], dp[i] + map[i][1]);
            }

            // 일을 안했을 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            max = Math.max(max, dp[i + 1]);
        }

        System.out.println(max);
    }
}