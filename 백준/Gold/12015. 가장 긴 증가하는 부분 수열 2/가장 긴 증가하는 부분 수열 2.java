import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int LIS = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(dp, arr[i], 0, LIS, LIS + 1);
            if (idx == -1) {
                dp[LIS++] = arr[i];
            } else {
                dp[idx] = arr[i];
            }
        }
        System.out.println(LIS);
    }

    private static int binarySearch(int[] dp, int target, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (dp[mid] >= target) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start == size) {
            return -1;
        } else {
            return res;
        }
    }
}