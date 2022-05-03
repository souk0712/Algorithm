package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java11123 {
    static int totalSheep = 0;
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int a = 0; a < t; a++) {
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            String[][] array = new String[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    array[i][j] = str[j];
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (array[i][j].equals("#"))
                        if (!visited[i][j]) {
                            dfs(array, i, j, visited);
                            totalSheep++;
                        }
                }
            }
            sb.append(totalSheep + " ");
            totalSheep = 0;
        }
        System.out.println(sb);
    }

    private static void dfs(String[][] array, int i, int j, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;

        int[][] pos = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int a = 0; a < 4; a++) {
            int x = i + pos[a][0];
            int y = j + pos[a][1];
            if (x < 0 || x >= h || y < 0 || y >= w) continue;
            if (visited[x][y]) continue;

            if (array[x][y].equals(".")) continue;

            dfs(array, x, y, visited);
        }
    }
}
