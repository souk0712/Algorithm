import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        q.add(new int[]{0, 0, 1});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                ans = Math.min(ans, cur[2]);
            }

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                int c = cur[2] + 1;
                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (v[x][y] || map[x][y] == '0') continue;
                v[x][y] = true;
                q.add(new int[]{x, y, c});
            }
        }
    }
}