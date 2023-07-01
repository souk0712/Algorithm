import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, min, total;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static ArrayList<int[]> ripeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][M][H];
        ripeList = new ArrayList<>();
        total = 0;

        // 1은 익은 토마토, 0 은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[n][m][h] = Integer.parseInt(st.nextToken());
                    if (map[n][m][h] == 0) total++;
                    else if (map[n][m][h] == 1) ripeList.add(new int[]{n, m, h});
                }
            }
        }

        if (total == 0) {
            min = 0;
        } else {
            min = Math.min(min, bfs());
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>(ripeList);

        int day = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();

                for (int k = 0; k < dx.length; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    int z = cur[2] + dz[k];

                    if (x < 0 || y < 0 || z < 0 || x >= N || y >= M || z >= H) continue;
                    if (map[x][y][z] != 0) continue;

                    q.add(new int[]{x, y, z});
                    map[x][y][z] = 1;
                    total--;
                }

                if (total == 0) return day;
            }
            day++;
        }
        return -1;
    }
}