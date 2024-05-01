import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, K, ans;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visit = new boolean[4][N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < dx.length; k++) {
                        if (visit[k][i][j] || map[i][j] == 0) continue;
                        dfs(i, j, k, 1);
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int i, int j, int k, int cnt) {
        visit[k][i][j] = true;
        if (cnt > K) {
            return;
        }

        int mx = i + dx[k];
        int my = j + dy[k];
        if (mx < 0 || my < 0 || mx >= N || my >= N) {
            if (cnt == K) {
                ans++;
            }
            return;
        }
        if (visit[k][mx][my]) return;
        if (map[mx][my] == 0) {
            if (cnt == K) {
                ans++;
            }
            return;
        }
        visit[k][mx][my] = true;
        dfs(mx, my, k, cnt + 1);
    }
}