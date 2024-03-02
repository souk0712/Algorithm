import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long ans = 1_000_000_000;
        for (int i = 1; i < (1 << N); i++) {
            long sour = 1;
            long bitter = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    int[] a = arr[j];
                    sour *= a[0];
                    bitter += a[1];
                }
            }
            long diff = Math.abs(sour - bitter);
            ans = Math.min(diff, ans);
        }
        System.out.println(ans);
    }
}