import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(st.nextToken());
            arr[i] = input;
        }

        int left = 0, right = N - 1;
        long min = Long.MAX_VALUE;
        int ml = 0, mr = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }

            if (sum >= 0) right--;
            else left++;
        }

        System.out.println(arr[ml] + " " + arr[mr]);
    }
}