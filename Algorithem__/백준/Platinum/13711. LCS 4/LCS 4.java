import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> first = new HashMap<>();
        int[] second = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            first.put(Integer.parseInt(st.nextToken()), j);
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            second[j] = first.get(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[N];
        int LIS = 1;
        dp[0] = second[0];
        for (int i = 1; i < N; i++) {
            int idx = binarySearch(dp, 0, LIS, second[i], LIS + 1);

            if (idx == -1) {
                dp[LIS++] = second[i];
            } else {
                dp[idx] = second[i];
            }
        }

        System.out.println(LIS);
    }

    private static int binarySearch(int[] dp, int left, int right, int target, int size) {
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target <= dp[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == size ? -1 : res;
    }
}