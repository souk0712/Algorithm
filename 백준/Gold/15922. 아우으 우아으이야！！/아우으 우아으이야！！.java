import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        long sum = 0;
        long left = arr[0][0];
        long right = arr[0][1];
        for (int i = 1; i < N; i++) {
            long[] cur = arr[i];
            if (right >= cur[0]) {
                right = Math.max(right, cur[1]);
            } else {
                long dist = Math.abs(left - right);
                sum += dist;
                left = cur[0];
                right = cur[1];
            }
        }
        long dist = Math.abs(left - right);
        sum += dist;
        System.out.println(sum);
    }
}