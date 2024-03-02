import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static int startX, startY, endX, endY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] score = {5, 5, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'C') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        int res = dijkstra();
        System.out.println(res == Integer.MAX_VALUE ? "dodo sad" : res);
    }

    private static int dijkstra() {
        dist = new int[N][M];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[startX][startY] = 0;
        pq.offer(new Point(startX, startY, dist[startX][startY]));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (dist[cur.x][cur.y] < cur.health) continue;
            if (cur.x == endX && cur.y == endY) {
                return dist[endX][endY];
            }
            if (map[cur.x][cur.y] == 'L') {
                int mx = cur.x - 1;
                if (checkRange(mx, cur.y) && dist[mx][cur.y] > dist[cur.x][cur.y] + 5) {
                    dist[mx][cur.y] = dist[cur.x][cur.y] + 5;
                    pq.offer(new Point(mx, cur.y, dist[mx][cur.y]));
                }
            }
            if (map[cur.x][cur.y] != 'X') {
                for (int k = 1; k < dx.length; k++) {
                    int mx = cur.x + dx[k];
                    int my = cur.y + dy[k];
                    if (checkRange(mx, my) && dist[mx][my] > dist[cur.x][cur.y] + score[k]) {
                        if (k == 1 && map[mx][my] != 'L') continue;
                        dist[mx][my] = dist[cur.x][cur.y] + score[k];
                        pq.offer(new Point(mx, my, dist[mx][my]));
                    }
                }
            }
            if (map[cur.x][cur.y] == 'X') {
                int mx = cur.x + 1;
                while (checkRange(mx, cur.y) && map[mx][cur.y] == 'X') {
                    mx += 1;
                }
                if (checkRange(mx, cur.y) && dist[mx][cur.y] > dist[cur.x][cur.y] + 10) {
                    dist[mx][cur.y] = dist[cur.x][cur.y] + 10;
                    pq.offer(new Point(mx, cur.y, dist[mx][cur.y]));
                }
            }
        }
        return dist[endX][endY];
    }

    private static boolean checkRange(int mx, int my) {
        return mx >= 0 && my >= 0 && mx < N && my < M && map[mx][my] != 'D';
    }

    static class Point implements Comparable<Point> {
        int x, y, health;

        Point(int x, int y, int health) {
            this.x = x;
            this.y = y;
            this.health = health;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(health, o.health);
        }
    }
}