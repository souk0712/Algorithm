import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static int ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        ans = 0;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        Set<Character> visited = new HashSet<>();
        visited.add(map[0][0]);
        dfs(0, 0, visited, 1);

        System.out.println(ans);
    }

    private static void dfs(int x, int y, Set<Character> visited, int cnt) {
        ans = Math.max(ans, cnt);

        for (int k = 0; k < 4; k++) {
            int mx = x + dx[k];
            int my = y + dy[k];
            if (isOutRange(mx, my)) continue;
            if (visited.contains(map[mx][my])) continue;
            visited.add(map[mx][my]);
            dfs(mx, my, visited, cnt + 1);
            visited.remove(map[mx][my]);
        }
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }
}