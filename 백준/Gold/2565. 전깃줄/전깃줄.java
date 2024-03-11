import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 500;
        int[] arr = new int[INF+1];
        int[] dp = new int[INF];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A] = B;
        }

        int LIS = 0;
        for (int i = 1; i <= 500; i++) {
            if (arr[i] == 0) continue;
            int idx = binarySearch(dp, arr[i], 0, LIS, LIS + 1);
            if (idx == -1) {
                dp[LIS++] = arr[i];
            } else {
                dp[idx] = arr[i];
            }
        }
        System.out.println(N - LIS);
    }

    static int binarySearch(int[] dp, int target, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < dp[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start == size ? -1 : res;
    }
}