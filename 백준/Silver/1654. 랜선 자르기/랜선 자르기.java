import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static long[] line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        line = new long[K];

        for (int i = 0; i < K; i++) {
            line[i] = Long.parseLong(br.readLine());
        }

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long ans = 0;
        long start = 0, end = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (determination(mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private static boolean determination(long length) {
        long cnt = 0;
        for (long l : line) {
            cnt += l / length;
        }

        return cnt >= N;
    }
}