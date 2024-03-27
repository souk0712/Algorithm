import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, M, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            ans = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            if (N < M) {
                move(A, B);
            } else {
                move(B, A);
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void move(int[] a, int[] b) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp += b[i] * a[i];
        }
        ans = Math.max(ans, temp);

        for (int i = 1; i <= b.length - a.length; i++) {
            int sum = 0;
            for (int j = i, k = 0; j < i + a.length; j++) {
                sum += b[j] * a[k];
                k++;
            }
            ans = Math.max(ans, sum);
        }
    }
}