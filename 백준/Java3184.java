package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java3184 {
    static int sheep = 0;
    static int wolf = 0;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        int totalSheep = 0;
        int totalWolf = 0;

        String[][] array = new String[r][c];
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                array[i][j] = str[j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!array[i][j].equals("#")) {
//                    dfs(array, i, j, visited);
                    bfs(array, i, j, visited);
                    if (wolf < sheep) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }

                    sheep = 0;
                    wolf = 0;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void dfs(String[][] array, int i, int j, boolean[][] visited) {

        if (visited[i][j]) return;
        if (array[i][j].equals("v")) {
            wolf++;
        } else if (array[i][j].equals("o")) {
            sheep++;
        }

        int pos[][] = {{1, 0, -1, 0}, {0, 1, 0, -1}};
        visited[i][j] = true;

        for (int a = 0; a < 4; a++) {
            int x = pos[0][a] + i;
            int y = pos[1][a] + j;

            if (0 > x || x >= r || 0 > y || y >= c) continue;
            if (visited[x][y]) continue;
            if (array[x][y].equals("#")) continue;

            dfs(array, x, y, visited);
        }
    }

    private static void bfs(String[][] array, int i, int j, boolean[][] visited) {
        int pos[][] = {{1, 0, -1, 0}, {0, 1, 0, -1}};
        Queue<int[][]> queue = new LinkedList<>();
        int[][] in = {{i, j}};
        queue.offer(in);

        if(visited[i][j]) return;
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[][] arr = queue.poll();
            if (array[arr[0][0]][arr[0][1]].equals("v")) {
                wolf++;
            } else if (array[arr[0][0]][arr[0][1]].equals("o")) {
                sheep++;
            }
            for (int a = 0; a < 4; a++) {
                int x = arr[0][0] + pos[0][a];
                int y = arr[0][1] + pos[1][a];

                if (x < 0 || x >= r || y < 0 || y >= c) continue;
                if (visited[x][y]) continue;
                if (array[x][y].equals("#")) continue;

                int[][] next = {{x, y}};
                queue.offer(next);
                visited[x][y] = true;
            }
        }
    }
}
