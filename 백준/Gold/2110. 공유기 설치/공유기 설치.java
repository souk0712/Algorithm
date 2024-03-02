import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long limit = arr[N - 1] - arr[0];
        long start = 1;
        long end = limit;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int count = count(N, arr, mid);
            if (C <= count) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static int count(int N, long[] arr, long mid) {
        int res = 1;
        long compare = arr[0];
        for (int i = 1; i < N; i++) {
            long dist = arr[i] - compare;
            if (dist >= mid) {
                res++;
                compare = arr[i];
            }
        }
        return res;
    }
}