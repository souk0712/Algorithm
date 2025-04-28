import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y, k;
    static int[][] map, dice;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dice = new int[4][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int res = moveDice(Integer.parseInt(st.nextToken()));
            if (res != -1) {
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int moveDice(int k) {
        int mx = x + dx[k - 1];
        int my = y + dy[k - 1];
        if (checkRangeOut(mx, my)) return -1;
        x = mx;
        y = my;
        if (k == 1) {
            rollRight();
        } else if (k == 2) {
            rollLeft();
        } else if (k == 3) {
            rollTop();
        } else if (k == 4) {
            rollBottom();
        }
        if (map[x][y] == 0) {
            map[x][y] = dice[3][1];
        } else {
            dice[3][1] = map[x][y];
            map[x][y] = 0;
        }

        return dice[1][1];
    }

    private static boolean checkRangeOut(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static void rollTop() {
        int[][] temp = new int[4][3];
        temp[0][1] = dice[1][1];    // 1
        temp[3][1] = dice[0][1];    // 2
        temp[1][2] = dice[1][2];    // 3
        temp[1][0] = dice[1][0];    // 4
        temp[1][1] = dice[2][1];    // 5
        temp[2][1] = dice[3][1];    // 6
        dice = temp;
    }

    private static void rollBottom() {
        int[][] temp = new int[4][3];
        temp[2][1] = dice[1][1];    // 1
        temp[1][1] = dice[0][1];    // 2
        temp[1][2] = dice[1][2];    // 3
        temp[1][0] = dice[1][0];    // 4
        temp[3][1] = dice[2][1];    // 5
        temp[0][1] = dice[3][1];    // 6
        dice = temp;
    }

    private static void rollLeft() {
        int[][] temp = new int[4][3];
        temp[1][0] = dice[1][1];    // 1
        temp[0][1] = dice[0][1];    // 2
        temp[1][1] = dice[1][2];    // 3
        temp[3][1] = dice[1][0];    // 4
        temp[2][1] = dice[2][1];    // 5
        temp[1][2] = dice[3][1];    // 6
        dice = temp;
    }

    private static void rollRight() {
        int[][] temp = new int[4][3];
        temp[1][2] = dice[1][1];    // 1
        temp[0][1] = dice[0][1];    // 2
        temp[3][1] = dice[1][2];    // 3
        temp[1][1] = dice[1][0];    // 4
        temp[2][1] = dice[2][1];    // 5
        temp[1][0] = dice[3][1];    // 6
        dice = temp;
    }
}