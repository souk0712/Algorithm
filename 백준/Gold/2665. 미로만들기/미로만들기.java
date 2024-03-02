import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int sx, int sy) {
        Deque<int[]> ad = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        ad.offer(new int[]{sx, sy, 0});
        visit[sx][sy] = true;

        while (!ad.isEmpty()) {
            int[] cur = ad.poll();
            if (cur[0] == N - 1 && cur[1] == N - 1) {
                return cur[2];
            }

            for (int k = 0; k < dx.length; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) {
                    ad.offerLast(new int[]{nx, ny, cur[2] + 1});
                } else {
                    ad.offerFirst(new int[]{nx, ny, cur[2]});
                }
                visit[nx][ny] = true;
            }
        }
        return 0;
    }
}