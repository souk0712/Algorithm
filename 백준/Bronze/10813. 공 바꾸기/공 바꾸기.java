import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] balls = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            balls[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken());
            int jj = Integer.parseInt(st.nextToken());
            int temp = balls[ii];
            balls[ii] = balls[jj];
            balls[jj] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < balls.length; i++) {
            sb.append(balls[i]).append(" ");
        }
        System.out.println(sb);
    }
}