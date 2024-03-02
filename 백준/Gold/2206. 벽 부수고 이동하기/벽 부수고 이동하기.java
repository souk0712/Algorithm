import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[N][M][2];
        q.offer(new int[]{sx, sy, 1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }
            
            if (visit[cur[0]][cur[1]][cur[3]]) continue;
            visit[cur[0]][cur[1]][cur[3]] = true;

            for (int k = 0; k < dx.length; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (mx < 0 || my < 0 | mx >= N || my >= M) continue;
                if (visit[mx][my][cur[3]]) continue;
                if (map[mx][my] == 1 && cur[3] < 1) {
                    q.offer(new int[]{mx, my, cur[2] + 1, cur[3] + 1});
                } else if (map[mx][my] == 0) {
                    q.offer(new int[]{mx, my, cur[2] + 1, cur[3]});
                }
            }
        }
        return -1;
    }
}