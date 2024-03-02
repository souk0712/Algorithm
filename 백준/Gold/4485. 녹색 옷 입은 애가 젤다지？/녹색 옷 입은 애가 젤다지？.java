import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int n = 0; n < N; n++) {
                String[] input = br.readLine().split(" ");
                for (int t = 0; t < N; t++) {
                    map[n][t] = Integer.parseInt(input[t]);
                    dist[n][t] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0, map[0][0]);
            sb.append("Problem ").append(T++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j, int initCost) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(i, j, initCost));
        visited[i][j] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int d = 0; d < 4; d++) {
                int x = cur.x + dx[d];
                int y = cur.y + dy[d];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;
                if (visited[x][y]) continue;
                if (dist[x][y] > (map[x][y] + cur.cost)) {
                    dist[x][y] = map[x][y] + cur.cost;
                    visited[x][y] = true;
                    pq.offer(new Node(x, y, dist[x][y]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}