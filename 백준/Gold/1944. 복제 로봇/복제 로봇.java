import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<int[]> nodes;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S' || map[i][j] == 'K') {
                    nodes.add(new int[]{i, j});
                }
            }
        }
        list = new ArrayList[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) list[i] = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            bfs(i);
        }

        System.out.println(prim());
    }

    private static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[nodes.size()];
        pq.offer(new Node(1, 0));

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.from]) continue;
            visit[cur.from] = true;
            sum += cur.cost;
            count++;

            for (int i = 0; i < list[cur.from].size(); i++) {
                Node n = list[cur.from].get(i);
                if (visit[n.from]) continue;
                pq.offer(n);

            }
        }
        if (count != nodes.size()){
            return -1;
        }
        return sum;
    }

    private static void bfs(int i) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        int[] n1 = nodes.get(i);
        q.offer(new int[]{n1[0], n1[1], 0});
        visit[n1[0]][n1[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (mx < 0 || my < 0 || mx >= N || my >= N) continue;
                if (visit[mx][my] || map[mx][my] == '1') continue;
                if (map[mx][my] == 'S' || map[mx][my] == 'K') {
                    for (int j = 0; j < nodes.size(); j++) {
                        int[] n2 = nodes.get(j);
                        if (n2[0] == mx && n2[1] == my) {
                            list[i].add(new Node(j, cur[2] + 1));
                        }
                    }
                }
                q.offer(new int[]{mx, my, cur[2] + 1});
                visit[mx][my] = true;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int from, cost;

        Node(int from, int cost) {
            this.from = from;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}