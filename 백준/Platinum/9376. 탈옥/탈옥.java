import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static char[][] map;
    static int[][][] count;
    static ArrayList<Point> people;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1,};
    private static final int INF = 10001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            people = new ArrayList<>();
            count = new int[3][h + 2][w + 2];
            for (char[] m : map) {
                Arrays.fill(m, '.');
            }
            for (int[][] c : count) {
                for (int[] cc : c) {
                    Arrays.fill(cc, INF);
                }
            }
            people.add(new Point(0, 0, 0));
            for (int i = 1; i <= h; i++) {
                String str = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = str.charAt(j - 1);
                    if (map[i][j] == '$') {
                        people.add(new Point(i, j, 0));
                    }
                }
            }

            for (int i = 0; i < people.size(); i++) {
                Point person = people.get(i);
                bfs(person, i);
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    if (map[i][j] == '*') continue;

                    int sum = count[0][i][j] + count[1][i][j] + count[2][i][j];
                    if (map[i][j] == '#') {
                        sum -= 2;
                    }
                    min = Math.min(sum, min);
                }
            }
            sb.append(min == Integer.MAX_VALUE ? 0 : min).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Point person, int index) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[][] visit = new boolean[h + 2][w + 2];
        q.offer(person);
        visit[person.x][person.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if (mx < 0 || my < 0 || mx >= h + 2 || my >= w + 2) continue;
                if (visit[mx][my]) continue;
                if (map[mx][my] == '#') {
                    q.offer(new Point(mx, my, cur.cnt + 1));
                    visit[mx][my] = true;
                    count[index][mx][my] = cur.cnt + 1;
                } else if (map[mx][my] != '*') {
                    q.offer(new Point(mx, my, cur.cnt));
                    visit[mx][my] = true;
                    count[index][mx][my] = cur.cnt;
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(cnt, o.cnt);
        }
    }
}