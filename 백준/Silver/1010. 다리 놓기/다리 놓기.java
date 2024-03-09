import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // r
            int M = Integer.parseInt(st.nextToken());   // n
            int[][] dp = new int[30][30];
            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}