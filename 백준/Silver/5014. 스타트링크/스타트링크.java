import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visit = new boolean[F + 1];

        int ans = bfs();
        System.out.println(ans == -1 ? "use the stairs" : ans);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        visit[S] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == G) {
                return cur[1] ;
            }

            // up의 경우
            int up = cur[0] + U;
            if (checkRange(up) && !visit[up]) {
                q.add(new int[]{up, cur[1] + 1});
                visit[up] = true;
            }
            // down의 경우
            int down = cur[0] - D;
            if (checkRange(down) && !visit[down]) {
                q.add(new int[]{down, cur[1] + 1});
                visit[down] = true;
            }
        }

        return -1;
    }

    private static boolean checkRange(int i) {
        return i >= 1 && i <= F;
    }
}