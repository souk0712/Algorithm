import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long l = Long.parseLong(st.nextToken());
            sb.append(upperBound(arr, l) - lowerBound(arr, l)).append(" ");
        }

        System.out.println(sb);
    }

    private static int lowerBound(long[] arr, long target) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (target <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int upperBound(long[] arr, long target) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}