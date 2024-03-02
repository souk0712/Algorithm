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
        int start = 0, end = 0;
        int sum = 0, count = 0, min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (start < N) {
            if (sum >= S) {
                min = Math.min(min, count);
                sum -= arr[start++];
                count--;
            } else if (end < N) {
                sum += arr[end++];
                count++;
            } else {
                sum -= arr[start++];
                count--;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}