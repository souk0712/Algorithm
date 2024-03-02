import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int exp = Integer.parseInt(br.readLine());
            arr[i] = exp;
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (i + 1 != arr[i]) {
                ans += Math.abs(i + 1 - arr[i]);
            }
        }

        System.out.println(ans);
    }
}