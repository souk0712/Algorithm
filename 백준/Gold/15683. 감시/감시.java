import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, min;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};    // 위, 아래, 왼, 오
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<CCTV> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(min);
    }

    private static void dfs(int cnt, int[][] map) {
        if (cnt == list.size()) {
            min = Math.min(min, countMap(map));
            return;
        }

        CCTV cctv = list.get(cnt);
        int[][] temp;

        switch (cctv.no) {
            case 1:
                for (int k = 0; k < dx.length; k++) {
                    temp = copyMap(map);
                    checkDir(temp, cctv.x, cctv.y, k);
                    dfs(cnt + 1, temp);
                }
                break;

            case 2:
                // ← →
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 2);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // ↑ ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 1);
                dfs(cnt + 1, temp);
                break;

            case 3:
                // ↑ →
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // → ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // ← ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 2);
                dfs(cnt + 1, temp);

                // ← ↑
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 2);
                checkDir(temp, cctv.x, cctv.y, 0);
                dfs(cnt + 1, temp);
                break;

            case 4:
                // ← ↑ →
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 2);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // ↑ → ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // ← ↓ →
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 2);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);

                // ↑ ← ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 2);
                dfs(cnt + 1, temp);
                break;

            case 5:
                // ← ↑ → ↓
                temp = copyMap(map);
                checkDir(temp, cctv.x, cctv.y, 0);
                checkDir(temp, cctv.x, cctv.y, 1);
                checkDir(temp, cctv.x, cctv.y, 2);
                checkDir(temp, cctv.x, cctv.y, 3);
                dfs(cnt + 1, temp);
                break;
        }
    }

    public static void checkDir(int[][] map, int x, int y, int k) {
        int mx = x + dx[k];
        int my = y + dy[k];

        if (mx < 0 || my < 0 || mx >= N || my >= M) return;
        if (map[mx][my] == 6) return;
        if (map[mx][my] == 0)
            map[mx][my] = -1;
        checkDir(map, mx, my, k);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] temp = new int[N][M];
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                temp[j][k] = map[j][k];
            }
        }
        return temp;
    }

    private static int countMap(int[][] map) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static class CCTV {
        int x, y, no;

        public CCTV(int x, int y, int no) {
            this.x = x;
            this.y = y;
            this.no = no;
        }
    }
}