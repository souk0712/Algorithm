import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[] weight, marbles;
    static boolean[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        marbles = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[45001];

        // 추
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int w = weight[i - 1];
            tmp.add(w);
            // 구슬
            for (int j = 1; j <= 15000; j++) {
                if (dp[j]) {
                    // 구슬 + 다른 추, 추
                    if (w - j > 0) {
                        tmp.add(w - j);
                    }
                    // 구슬 + 추, 다른 추
                    if (w + j <= 15000) {
                        tmp.add(w + j);
                    }
                    // 구슬, 추 + 다른 추
                    if (j - w > 0) {
                        tmp.add(j - w);
                    }
                }
            }
            for (int t : tmp) {
                dp[t] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m : marbles) {
            sb.append(dp[m] ? "Y" : "N").append(" ");
        }
        System.out.println(sb);
    }
}