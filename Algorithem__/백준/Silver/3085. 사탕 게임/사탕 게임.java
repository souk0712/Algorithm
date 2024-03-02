import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        int ans = countCandy(map);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char[][] copyMap = copyMap();
                // 오른쪽
                if (swap(copyMap, i, j, 0)) {
                    ans = Math.max(ans, countCandy(copyMap));
                }
                copyMap = copyMap();
                // 아래쪽
                if (swap(copyMap, i, j, 1)) {
                    ans = Math.max(ans, countCandy(copyMap));
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean swap(char[][] copyMap, int i, int j, int dir) {
        int mx = i + dx[dir];
        int my = j + dy[dir];
        if (mx < 0 || my < 0 || mx >= N || my >= N) return false;
        if (copyMap[i][j] == copyMap[mx][my]) return false;
        char temp = copyMap[i][j];
        copyMap[i][j] = copyMap[mx][my];
        copyMap[mx][my] = temp;
        return true;
    }

    private static char[][] copyMap() {
        char[][] res = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = map[i][j];
            }
        }
        return res;
    }

    private static int countCandy(char[][] map) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            char com = map[i][0];
            for (int j = 1; j < N; j++) {
                if (com == map[i][j]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    com = map[i][j];
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        for (int j = 0; j < N; j++) {
            int cnt = 1;
            char com = map[0][j];
            for (int i = 1; i < N; i++) {
                if (com == map[i][j]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    com = map[i][j];
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}