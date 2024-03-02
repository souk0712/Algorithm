import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        for (int i = 0; i < N; i++) {
            // 가로
            if (checkPath(i, 0, true))
                ans++;

            // 세로
            if (checkPath(0, i, false))
                ans++;
        }

        System.out.println(ans);
    }

    private static boolean checkPath(int x, int y, boolean flag) {
        boolean[] visited = new boolean[N];
        int[] height = new int[N];

        for (int i = 0; i < N; i++) {
            if (flag)
                height[i] = map[x][i];
            else
                height[i] = map[i][y];
        }

        for (int i = 0; i < N - 1; i++) {
            int diff = height[i] - height[i + 1];

            if (diff == 0) {            // 같은 높이
                continue;
            } else if (diff == 1) {     // 차이 1
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || height[i + 1] != height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            } else if (diff == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            } else {                     // 차이 2이상
                return false;
            }
        }

        return true;
    }
}