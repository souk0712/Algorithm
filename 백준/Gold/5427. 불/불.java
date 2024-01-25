import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int W, H;
    static char[][] map;
    static int x, y;
    static Queue<Point> fires, person;
    static boolean[][] visit;
    static StringBuilder sb;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fires = new LinkedList<>();
            person = new LinkedList<>();
            visit = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        x = i;
                        y = j;
                    } else if (map[i][j] == '*') {
                        fires.offer(new Point(i, j));
                    }
                }
            }
            escape();
        }
        System.out.println(sb);
    }

    private static void escape() {
        int time = 0;
        person.offer(new Point(x, y));
        visit[x][y] = true;

        while (!person.isEmpty()) {
            burn();
            time++;
            int size = person.size();
            for (int s = 0; s < size; s++) {
                Point cur = person.poll();
                for (int k = 0; k < dx.length; k++) {
                    int mx = cur.x + dx[k];
                    int my = cur.y + dy[k];
                    if (checkRange(mx, my)) {
                        sb.append(time).append("\n");
                        return;
                    }
                    if (!visit[mx][my] && map[mx][my] == '.') {
                        visit[mx][my] = true;
                        person.offer(new Point(mx, my));
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE\n");
    }

    private static void burn() {
        int size = fires.size();
        for (int s = 0; s < size; s++) {
            Point cur = fires.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if (checkRange(mx, my)) continue;
                if (map[mx][my] == '.' || map[mx][my] == '@') {
                    map[mx][my] = '*';
                    fires.offer(new Point(mx, my));
                }
            }
        }
    }

    private static boolean checkRange(int mx, int my) {
        return mx < 0 || my < 0 || mx >= H || my >= W;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}