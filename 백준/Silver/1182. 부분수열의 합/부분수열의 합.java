import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, ans;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            sum(0, 0, i, 0);
        }

        System.out.println(ans);
    }

    private static void sum(int start, int n, int r, int sum) {
        if (n == r) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            sum(i + 1, n + 1, r, sum + arr[i]);
            visit[i] = false;
        }
    }
}