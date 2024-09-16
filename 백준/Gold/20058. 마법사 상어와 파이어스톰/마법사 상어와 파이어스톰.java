import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, size;
    static int[] L;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < Q; q++) {
            int length = (int) Math.pow(2, L[q]);
            // 시계방향으로 90도 회전
            for (int i = 0; i < size; i += length) {
                for (int j = 0; j < size; j += length) {
                    map = rotate(i, j, length);
                }
            }
            // 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
            int[][] temp = copyMap();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (temp[i][j] > 0 && reduceIce(temp, i, j)) {
                        map[i][j]--;
                    }
                }
            }
        }
        // 남아있는 얼음 A[r][c]의 합
        System.out.println(sumIce());
        // 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
        int hugeCount = 0;
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visited[i][j] || map[i][j] <= 0) continue;
                hugeCount = Math.max(hugeCount, bfs(visited, i, j));
            }
        }
        System.out.println(hugeCount);
    }

    private static int bfs(boolean[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 1});
        visited[i][j] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            for (int k = 0; k < 4; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (checkRangeOut(mx, my)) continue;
                if (visited[mx][my] || map[mx][my] <= 0) continue;
                q.offer(new int[]{mx, my, cur[2] + 1});
                visited[mx][my] = true;
            }
        }
        return count;
    }

    private static int sumIce() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static boolean reduceIce(int[][] map, int x, int y) {
        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (checkRangeOut(nx, ny)) continue;
            if (map[nx][ny] <= 0) continue;
            count++;
        }
        return count < 3;
    }

    private static boolean checkRangeOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= size || ny >= size;
    }

    private static int[][] rotate(int x, int y, int length) {
        int[][] res = copyMap();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                res[j + x][y + length - i - 1] = map[x + i][y + j];
            }
        }
        return res;
    }

    private static int[][] copyMap() {
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res[i][j] = map[i][j];
            }
        }
        return res;
    }
}