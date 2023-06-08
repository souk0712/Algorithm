import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] start;
    static int[][] power;
    static boolean[] visited;
    static int N;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        power = new int[N + 1][N + 1];
        start = new int[N / 2];
        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 1);

        System.out.println(min);
    }

    private static void comb(int cnt, int index) {
        if (cnt == N / 2) {
            int[] link = new int[N / 2];
            int startSum = 0;
            int linkSum = 0;

            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    startSum += power[start[i]][start[j]] + power[start[j]][start[i]];
                }
            }

            for (int i = 1, j = 0; i <= N; i++) {
                if (!visited[i]) {
                    link[j++] = i;
                }
            }

            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    linkSum += power[link[i]][link[j]] + power[link[j]][link[i]];
                }
            }

            min = Math.min(min, Math.abs(linkSum - startSum));
            return;
        }

        for (int i = index; i <= N; i++) {
            visited[i] = true;
            start[cnt] = i;
            comb(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}