import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map, markMap;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        markMap = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || markMap[i][j] != 0) continue;
                markLand(i, j, ++index);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                visit[i][j] = true;
                makeBridge(i, j);
                visit = new boolean[N][N];
            }
        }

        System.out.println(min);
    }

    private static void makeBridge(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int index = markMap[i][j];
        q.add(new int[]{i, j, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] >= min) continue;

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (checkRange(x, y) || visit[x][y] || markMap[x][y] == index) continue;
                if (markMap[x][y] == 0) {
                    q.add(new int[]{x, y, cur[2] + 1});
                    visit[x][y] = true;
                } else {
                    min = Math.min(min, cur[2]);
                }
            }
        }
    }

    private static void markLand(int i, int j, int index) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        markMap[i][j] = index;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;
                if (map[x][y] == 0 || markMap[x][y] != 0) continue;

                q.add(new int[]{x, y});
                markMap[x][y] = index;
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}