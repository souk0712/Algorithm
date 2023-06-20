import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] a, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new int[N];
        dp = new int[N];
        int LIS = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            int idx = BinarySearch(a[i], 0, LIS, LIS + 1);

            if (idx == -1) {
                dp[LIS++] = a[i];
            } else {
                dp[idx] = a[i];
            }
        }
        System.out.println(LIS);
    }

    private static int BinarySearch(int target, int start, int end, int size) {
        int res = 0;

        while (start <= end) {
            // 중앙값
            int mid = (start + end) / 2;

            // target이 dp의 중앙값보다 작거나 같은 경우
            if (target <= dp[mid]) {
                res = mid;
                end = mid - 1;
            }
            // target이 dp의 중앙값보다 큰 경우
            else {
                start = mid + 1;
            }
        }

        // dp에서 삽입될 위치를 찾지 못한 경우(모든 수보다 큰 경우)
        if (start == size) {
            return -1;
        }
        // dp에서 삽입될 위치를 찾은 경우
        else {
            return res;
        }
    }
}