package lan_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Softeer_순서대로방문하기 {

    static int N, M, ans;
    static int[][] map, spots;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        spots = new int[M][2];
        visit = new boolean[N][N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            spots[i] = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        }
        visit[spots[0][0]][spots[0][1]] = true;
        dfs(spots[0][0], spots[0][1], 1);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int spotIndex) {
        if (x == spots[spotIndex][0] && y == spots[spotIndex][1]) {
            spotIndex++;
        }
        if (spotIndex == M) {
            ans++;
            return;
        }
        for (int k = 0; k < dx.length; k++) {
            int mx = x + dx[k];
            int my = y + dy[k];
            if (mx < 0 || my < 0 || mx >= N || my >= N) continue;
            if (visit[mx][my] || map[mx][my] == 1) continue;

            visit[mx][my] = true;
            dfs(mx, my, spotIndex);
            visit[mx][my] = false;
        }
    }
}