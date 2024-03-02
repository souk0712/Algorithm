import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] pick;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pick = new int[M];
        visited = new boolean[N + 1];

        perm(0);

        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i : pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            pick[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}