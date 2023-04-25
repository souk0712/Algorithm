import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N = 5;
    static char[][] site;
    static int[] selected;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        site = new char[N][N];
        selected = new int[7];
        answer = 0;

        for (int i = 0; i < N; i++) {
            site[i] = br.readLine().toCharArray();
        }

        comb(0, 0);
        System.out.println(answer);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 7) {
            if (bfs(selected)) {
                answer += 1;
            }
            return;
        }
        for (int i = start; i < 25; i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static int getX(int n) {
        return n / 5;
    }

    private static int getY(int n) {
        return n % 5;
    }

    private static boolean bfs(int[] selected) {
        Queue<Integer> q = new LinkedList<>();
        int sCnt = 0;
        int yCnt = 0;
        boolean[] visited = new boolean[7];
        q.add(selected[0]);
        visited[0] = true;
        if (site[getX(selected[0])][getY(selected[0])] == 'S') sCnt++;
        else yCnt++;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = getX(cur);
            int y = getY(cur);
            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                for (int i = 1; i < 7; i++) {
                    if (visited[i]) continue;
                    int mx = getX(selected[i]);
                    int my = getY(selected[i]);
                    if (mx == nx && my == ny) {
                        if (site[mx][my] == 'S') {
                            sCnt++;
                        } else yCnt++;
                        q.add(selected[i]);
                        visited[i] = true;
                    }
                    if (yCnt >= 4) return false;
                }
            }
        }
        if (sCnt + yCnt == 7) return true;
        return false;
    }
}