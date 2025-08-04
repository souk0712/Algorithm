import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};    // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<CCTV> cctvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvs = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        countMinSpace(map, 0);
        System.out.println(ans);
    }

    private static void countMinSpace(int[][] map, int cnt) {
        if (cnt == cctvs.size()) {
            ans = Math.min(ans, countMap(map));
            return;
        }
        int[][] newMap;
        CCTV cctv = cctvs.get(cnt);
        switch (cctv.num) {
            case 1:
                // →, ←, ↑, ↓
                for (int k = 0; k < 4; k++) {
                    newMap = copyMap(map);
                    fillDetectArea(cctv.x, cctv.y, newMap, k);
                    countMinSpace(newMap, cnt + 1);
                }
                break;
            case 2:
                // ←→, ↑↓
                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);
                break;
            case 3:
                // ↑→,↓→, ←↓, ←↑
                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);
                break;
            case 4:
                // ←↑→, ↑→↓, ←↓→, ←↑↓
                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                countMinSpace(newMap, cnt + 1);

                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);
                break;
            case 5:
                // ←↑→↓
                newMap = copyMap(map);
                fillDetectArea(cctv.x, cctv.y, newMap, 0);
                fillDetectArea(cctv.x, cctv.y, newMap, 1);
                fillDetectArea(cctv.x, cctv.y, newMap, 2);
                fillDetectArea(cctv.x, cctv.y, newMap, 3);
                countMinSpace(newMap, cnt + 1);
                break;
        }

    }

    private static int countMap(int[][] map) {
        int cnt = 0;
        for (int[] i : map) {
            for (int k : i) {
                if (k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void fillDetectArea(int x, int y, int[][] map, int dir) {
        while (true) {
            int mx = x + dx[dir];
            int my = y + dy[dir];
            if (isOutRange(mx, my)) break;
            if (map[mx][my] == 6) break;
            x = mx;
            y = my;
            if (map[mx][my] != 0) {
                continue;
            }
            map[mx][my] = -1;
        }
    }

    private static boolean isOutRange(int mx, int my) {
        return mx < 0 || mx >= N || my < 0 || my >= M;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static class CCTV {
        int num, x, y;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}