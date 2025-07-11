import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        long ans = calculate();
        System.out.println(ans);
    }

    private static long calculate() {
        long res = 0;
        double[] cnt = new double[N];
        for (int i = 1; i < N; i++) {
            double logRes = log2(arr[i - 1] / arr[i]);
            double k = Math.ceil(logRes) + cnt[i - 1];
            if (k > 0) {
                cnt[i] = k;
                res += (long) cnt[i];
            }
        }
        return res;
    }

    static double log2(double value) {
        return Math.log(value) / Math.log(2);
    }
}