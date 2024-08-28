import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        int res = 0;
        for (int k = 1; k <= maxHeight; k++) {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] >= k) continue;
                    res += bfs(i, j, k);
                }
            }
        }

        System.out.println(res);
    }

    private static int bfs(int i, int j, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        map[i][j]++;
        int cnt = 1;
        boolean check = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (checkOut(nx, ny)) {
                    check = true;
                    continue;
                }
                if (map[nx][ny] < height) {
                    map[nx][ny]++;
                    cnt++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (check) return 0;
        return cnt;
    }

    private static boolean checkOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
}