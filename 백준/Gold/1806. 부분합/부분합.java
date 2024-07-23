import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0;
        while (start < N) {
            if (end < N) {
                if (sum < S) {
                    sum += arr[end++];
                } else {
                    sum -= arr[start];
                    start++;
                }
            } else {
                sum -= arr[start];
                start++;
            }

            if (sum >= S) {
                ans = Math.min(ans, end - start);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}