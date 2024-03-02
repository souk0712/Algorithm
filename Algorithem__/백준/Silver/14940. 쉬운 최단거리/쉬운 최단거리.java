import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = new int[n][m];
        int goalX = 0, goalY = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);

                if (map[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)
                    ans[i][j] = -1;
            }
        }

        bfs(goalX, goalY);

        StringBuilder sb = new StringBuilder();
        
        for (int[] i : ans) {
            for (int n : i) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        ans[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x < 0 || y < 0 || x >= n || y >= m) continue;

                if (!visited[x][y] && map[x][y] == 1) {
                    queue.offer(new int[]{x, y});
                    ans[x][y] = ans[cur[0]][cur[1]] + 1;
                    visited[x][y] = true;
                }
            }
        }
    }
}