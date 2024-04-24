import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = N - 1;
            long sum = 0;
            long ans = 0;
            while (left < right) {
                sum = arr[left] + arr[right];
                if (sum > M) {
                    right--;
                } else {
                    left++;
                    ans = Math.max(sum, ans);
                }
            }
            sb.append(ans == 0 ? -1 : ans).append("\n");
        }
        System.out.println(sb);
    }
}