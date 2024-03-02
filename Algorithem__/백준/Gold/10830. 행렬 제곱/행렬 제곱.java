import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B;
    static long[][] arr;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] answer = pow(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j] % MOD).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static long[][] pow(long n) {
        if (n == 1)
            return arr;
        long[][] temp = pow(n / 2);
        if (n % 2 == 0) {
            return matrixMultiple(temp, temp);
        } else {
            return matrixMultiple(matrixMultiple(temp, temp), pow(1));
        }
    }

    private static long[][] matrixMultiple(long[][] a, long[][] b) {
        long[][] res = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += (a[i][k] * b[k][j]);
                }
                res[i][j] %= MOD;
            }
        }

        return res;
    }
}