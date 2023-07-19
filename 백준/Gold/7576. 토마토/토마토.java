import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans, total;
    static int[][] map;
    static ArrayList<int[]> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        total = 0;

        // 수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) list.add(new int[]{i, j});
                if (map[i][j] != -1) total++;
            }
        }
        if (total == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>(list);

        int day = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();

                if (map[cur[0]][cur[1]] == 1)
                    total--;

                if (total == 0) {
                    ans = Math.min(ans, day);
                }

                for (int k = 0; k < dx.length; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if (x < 0 || y < 0 || x >= N || y >= M) continue;
                    if (map[x][y] != 0) continue;
                    map[x][y] = 1;
                    q.add(new int[]{x, y});
                }
            }
            day++;
        }
    }
}