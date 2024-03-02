import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, max, safe;
    static int[][] map;
    static ArrayList<Position> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virusList = new ArrayList<>();
        safe = 0;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Position(i, j));
                } else if (map[i][j] == 0) {
                    safe++;
                }
            }
        }

        boundary(0);

        System.out.println(max);
    }

    private static void boundary(int cnt) {
        if (cnt == 3) {
            max = Math.max(max, spreadVirus(safe - 3));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    boundary(cnt + 1);
                    map[i][j] = 0;

                }
            }
        }
    }

    private static int spreadVirus(int count) {
        Queue<Position> q = new LinkedList<>(virusList);
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        while (!q.isEmpty()) {
            Position cur = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (temp[x][y] != 0) continue;

                q.add(new Position(x, y));
                count--;
                temp[x][y] = 2;
            }
        }

        return count;
    }

    public static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}