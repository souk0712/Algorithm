import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MOD = 1000000007;
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long ans = K;
        for (int i = 0; i < N; i++) {
            ans = ((ans % 1000000007) * (P % 1000000007)) % 1000000007;
        }

        System.out.println(ans);
    }
}