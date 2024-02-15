import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5);
            if (N == 0 && M == 0.0) break;
            int[][] candy = new int[N][2];
            int[] dp = new int[M + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5);
                candy[i][0] = c;
                candy[i][1] = p;
            }

            for (int i = 0; i < N; i++) {
                int[] cur = candy[i];
                for (int j = cur[1]; j < M + 1; j++) {
                    dp[j] = Math.max(dp[j - cur[1]] + cur[0], dp[j]);
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}