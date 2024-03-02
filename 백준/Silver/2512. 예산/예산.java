import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        M = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(max));
    }

    private static int binarySearch(int max) {
        int start = 0, end = max + 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static boolean check(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int value = arr[i];
            sum += Math.min(mid, value);
        }
        return sum <= M;
    }
}