import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max;
    static int[] flower;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flower = new int[N];
        dp = new int[N];
        max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            flower[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = flower[0];
        for (int j = 1; j < N; j++) {
            dp[j] = dp[j - 1] + flower[j];
        }

        // 벌-벌-꿀
        for (int i = 1; i < N - 1; i++) {
            int bbh1 = dp[N - 1] - flower[0] - flower[i];
            int bbh2 = dp[N - 1] - dp[i];
            max = Math.max(bbh1 + bbh2, max);

            // 벌-꿀-벌
            int bhb1 = dp[i] - flower[0];
            int bhb2 = dp[N - 2] - dp[i - 1];
            max = Math.max(bhb1 + bhb2, max);

            // 꿀-벌-벌
            int hbb1 = dp[i] - flower[i];
            int hbb2 = dp[N - 1] - flower[N - 1] - flower[i];
            max = Math.max(hbb1 + hbb2, max);
        }

        System.out.println(max);
    }
}