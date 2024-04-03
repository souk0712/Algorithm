import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[2 * n];
            long[] ans = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visit = new boolean[2 * n];
            for (int i = 0, index = 0; i < 2 * n - 1; i++) {
                long first = arr[i];
                if (visit[i]) continue;
                visit[i] = true;
                for (int j = i + 1; j < 2 * n; j++) {
                    long second = arr[j];
                    if (visit[j]) continue;
                    if ((first * 100) / 75 == second) {
                        ans[index++] = first;
                        visit[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}