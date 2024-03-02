import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int ans;
    static Position start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        map = new char[R][C];
        start = new Position(R - 1, 0, 1);
        end = new Position(0, C - 1, 0);
        ans = 0;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        visited[start.x][start.y] = true;
        dfs(start.x, start.y, 1);

        System.out.println(ans);
    }

    private static void dfs(int i, int j, int cnt) {
        if (i == end.x && j == end.y) {
            if (cnt == K) {
                ans++;
                return;
            }
        }

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= R || y >= C) continue;
            if (visited[x][y] || map[x][y] == 'T') continue;

            visited[x][y] = true;
            dfs(x, y, cnt + 1);
            visited[x][y] = false;
        }
    }

    public static class Position {
        int x, y, count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}