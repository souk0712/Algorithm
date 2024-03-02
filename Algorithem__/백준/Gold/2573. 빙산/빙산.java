import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        System.out.println(meltIceberg());
    }

    private static int meltIceberg() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            q.offer(list.get(i));
        }

        int time = 0;
        while (!q.isEmpty()) {
            int[][] temp = copyMap();
            if (labeling() >= 2) {
                return time;
            }

            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();

                for (int k = 0; k < dx.length; k++) {
                    int mx = cur[0] + dx[k];
                    int my = cur[1] + dy[k];
                    if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                    if (map[mx][my] == 0) {
                        if (temp[cur[0]][cur[1]] > 0) {
                            temp[cur[0]][cur[1]] -= 1;
                        }
                    }
                }

                if (temp[cur[0]][cur[1]] > 0) {
                    q.offer(new int[]{cur[0], cur[1]});
                }
            }
            time++;
            map = temp;
        }
        
        if (labeling() == 0) return 0;
        return time;
    }

    private static int labeling() {
        boolean[][] visit = new boolean[N][M];
        int[][] temp = copyMap();
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0 || visit[i][j]) continue;
                bfs(temp, visit, i, j);
                index++;
            }
        }

        return index;
    }

    private static int[][] copyMap() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    private static void bfs(int[][] map, boolean[][] visit, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = 0;

            for (int k = 0; k < dx.length; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];

                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if (visit[mx][my] || map[mx][my] == 0) continue;

                visit[mx][my] = true;
                q.offer(new int[]{mx, my});
            }
        }
    }
}