import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr_rev = new int[N];
        int[] i_dp = new int[N];
        int[] d_dp = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr_rev[N - i - 1] = arr[i];
        }

        Arrays.fill(i_dp, 1);
        Arrays.fill(d_dp, 1);

        // LIS
        LIS(arr, i_dp);
        LIS(arr_rev, d_dp);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = i_dp[i] + d_dp[N - i - 1] - 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static void LIS(int[] arr, int[] dp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
    }
}