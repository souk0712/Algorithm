import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, d, k, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(countKind());
    }

    private static int countKind() {
        int[] dp = new int[d + 1];
        int count = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            int choose = arr[i];
            if (dp[choose] == 0) {
                count++;
            }
            dp[choose]++;
        }
        max = count;

        for (int i = 0; i < N; i++) {
            if (count >= max) {
                if (dp[c] == 0) {
                    max = count + 1;
                } else {
                    max = count;
                }
            }
            dp[arr[i]]--;
            if (dp[arr[i]] == 0) count--;

            if (dp[arr[(i + k) % N]] == 0) count++;
            dp[arr[(i + k) % N]]++;
        }

        return max;
    }
}