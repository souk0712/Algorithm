package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Java2667 {
    static int total = 0;
    static ArrayList<Integer> count = new ArrayList<>();
    static int n;
    static int pr = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("1"))
                    if (!visited[i][j]) {
                        count.add(0);
                        dfs(map, i, j, visited);
                        total++;
                        pr++;
                    }
            }
        }
        System.out.println(total);
        Collections.sort(count);
        for (int a = 0; a < count.size(); a++)
            System.out.println(count.get(a));
    }

    private static void dfs(String[][] map, int i, int j, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        int value = count.get(pr);
        count.set(pr, ++value);
        int[][] pos = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int a = 0; a < 4; a++) {
            int x = i + pos[a][0];
            int y = j + pos[a][1];
            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            if (visited[x][y]) continue;
            if (map[x][y].equals("0")) continue;
            dfs(map, x, y, visited);
        }
    }
}
