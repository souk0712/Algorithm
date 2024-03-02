import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;
    static int[] pick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pick = new int[M];

        comb(1, 0);

        System.out.println(sb);
    }

    private static void comb(int start, int cnt) {
        if (cnt == M) {
            for (int i : pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            pick[cnt] = i;
            comb(i, cnt + 1);
        }
    }
}