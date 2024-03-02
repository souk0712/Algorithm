import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 0 1 2 3 4
// 5 6 7 8 9
// 10 11 12 13 14
// 15 16 17 18 19
// 20 21 22 23 24

public class Main {

    static final int N = 5;
    static int ans;
    static char[][] map;
    static boolean[] visit;
    static int[] pick;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][N];
        pick = new int[7];
        visit = new boolean[25];
        ans = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        comb(0, 0);

        System.out.println(ans);
    }

    private static void comb(int start, int cnt) {
        if (cnt == 7) {
            if (bfs()) {
                ans++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            pick[cnt] = i;
            comb(i + 1, cnt + 1);
            visit[i] = false;
        }
    }

    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[25];
        q.offer(pick[0]);

        int cnt = 1, s = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / N;
            int y = cur % N;
            if (map[x][y] == 'S') s++;
            check[cur] = true;

            for (int k = 0; k < dx.length; k++) {
                int mx = x + dx[k];
                int my = y + dy[k];
                int n = mx * N + my;

                if (mx < 0 || my < 0 || mx >= N || my >= N) continue;
                if (!visit[n] || check[n]) continue;

                cnt++;
                check[n] = true;
                q.offer(n);
            }
        }

        // 뽑힌 자리가 이어져있는지 && 뽑힌 자리의 S가 4이상인지
        return cnt == 7 && s >= 4;
    }
}