import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int startX, startY;
    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][2];
            for (int i = 0; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i][0] = x;
                arr[i][1] = y;
            }
            bfs();
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            int dist = getDist(startX, startY, arr[i][0], arr[i][1]);
            if (dist <= 1000) {
                dq.offer(new int[]{i, arr[i][0], arr[i][1]});
            }
        }

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == N) {
                sb.append("happy").append("\n");
                return;
            }

            for (int k = 0; k < N + 1; k++) {
                if (visit[k]) continue;
                int dist = getDist(cur[1], cur[2], arr[k][0], arr[k][1]);
                if (dist <= 1000) {
                    visit[k] = true;
                    dq.offer(new int[]{k, arr[k][0], arr[k][1]});
                }
            }
        }
        sb.append("sad").append("\n");
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}