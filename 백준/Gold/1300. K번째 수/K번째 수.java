import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long start = 0, end = (long) N * N;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (determination(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static boolean determination(long num) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(num / i, N);
        }

        return cnt < K;
    }
}