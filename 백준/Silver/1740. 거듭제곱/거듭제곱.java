import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long count = 0;
        long ans = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                ans += power(3, count);
            }
            count++;
            N >>= 1;
        }
        System.out.println(ans);
    }

    private static long power(long n, long p) {
        if (p == 0) return 1;
        long ans = 1;
        for (int i = 0; i < p; i++) {
            ans *= n;
        }
        return ans;
    }
}