import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] post, mid, pre;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            pre = new int[N];
            mid = new int[N];
            post = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mid[i] = Integer.parseInt(st.nextToken());
            }

            postOrder(0, N, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void postOrder(int s, int e, int pos) {
        for (int i = s; i < e; i++) {
            if (pre[pos] == mid[i]) {
                postOrder(s, i, pos + 1); // left
                postOrder(i + 1, e, pos + 1 + i - s); // right
                sb.append(mid[i]).append(" ");
            }
        }
    }
}