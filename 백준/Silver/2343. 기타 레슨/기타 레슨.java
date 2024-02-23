import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long start = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(arr[i], start);
        }
        long ans = 0;
        long end = 100_000 * 10_000;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = divideFilm(arr, mid);
            if (count <= M) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static long divideFilm(int[] arr, long mid) {
        int sum = 0;
        long res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                res++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return res;
    }
}