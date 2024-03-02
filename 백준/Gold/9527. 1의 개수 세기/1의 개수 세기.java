import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        dp = new long[56];
        dp[0] = 1;

        // 2^n의 누적합 채우기
        for (int i = 1; i < 56; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        System.out.println(count(B) - count(A - 1));
    }

    private static long count(long n) {
        long cnt = n & 1;
        // n보다 작은 2^n의 n의 최대값
        int size = (int) (Math.log(n) / Math.log(2));

        // dp[i - 1] : 000 ~ 111 개수, 00 ~ 11 개수, 0 ~ 1 개수
        for (int i = size; i > 0; i--) {
            long temp = 1L << i;
            if ((n & temp) != 0L) {
                // n - temp + 1 : n 까지의 맨 앞 1 개수 + 2^n일 때의 1개수
                cnt += dp[i - 1] + (n - temp + 1);
                n -= temp;
            }
        }

        return cnt;
    }
}