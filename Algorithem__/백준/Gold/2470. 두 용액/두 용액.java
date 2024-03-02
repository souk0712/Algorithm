import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long lValue = 0, rValue = 0;

        int left = 0, right = N - 1;
        long min = Integer.MAX_VALUE;

        while (left < right) {
            long diff = arr[left] + arr[right];

            if (min > Math.abs(diff)) {
                min = Math.abs(diff);
                lValue = arr[left];
                rValue = arr[right];
            }

            if (diff <= 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(lValue + " " + rValue);
    }
}