import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long X, Y, Z;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = getZ(X, Y);
        if (X == Y || Z == 99) {
            System.out.println(-1);
            return;
        }
        long start = X;
        long end = 2_000_000_001;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (checkZ(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start - X);
    }

    private static boolean checkZ(long mid) {
        long y = Y + (mid - X);
        long z = getZ(mid, y);
        return Z < z;
    }

    private static long getZ(long x, long y) {
        return y * 100 / x;
    }
}