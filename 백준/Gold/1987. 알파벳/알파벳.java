import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, max;
    static char[][] map;
    static boolean[] alpha;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        alpha = new boolean[26];
        max = Integer.MIN_VALUE;

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
            }
        }
        alpha[map[0][0] % 'A'] = true;
        dfs(0, 0, 0);

        System.out.println(max);
    }

    private static void dfs(int i, int j, int count) {
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= R || y >= C) continue;
            if (alpha[map[x][y] % 'A']) {
                max = Math.max(max, count + 1);
                continue;
            }

            alpha[map[x][y] % 'A'] = true;
            dfs(x, y, count + 1);
            alpha[map[x][y] % 'A'] = false;
        }
    }
}