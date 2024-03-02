import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 1; i <= N; i++) {
            int W = list.get(i - 1)[0];
            int V = list.get(i - 1)[1];
            for (int w = 1; w <= K; w++) {
                if (W <= w) {
                    dp[i][w] = Math.max(V + dp[i - 1][w - W], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}