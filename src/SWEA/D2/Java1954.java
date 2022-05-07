package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int count = 1;

            fun1(map, visited, 0, 0, count, N);
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < visited.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void fun1(int[][] map, boolean[][] visited, int i, int j, int count, int N) {
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (visited[i][j]) return;
        visited[i][j] = true;
        map[i][j] = count++;
        for (int k = 0; k < 4; k++) {
            int x = i + pos[k][0];
            int y = j + pos[k][1];
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (visited[x][y]) continue;
            fun1(map, visited, x, y, count, N);
        }
    }
}
