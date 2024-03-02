import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int LIS = 0;
        for (int i = 0; i < arr.length; i++) {
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
        int idx = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= dp[mid]) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start == size ? -1 : idx;
    }
}