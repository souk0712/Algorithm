package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java7562 {
    static int m;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < tCase; t++) {
            m = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[m][m];

            String[] inputS = br.readLine().split(" ");
            int[] start = {Integer.parseInt(inputS[0]), Integer.parseInt(inputS[1])};

            String[] inputE = br.readLine().split(" ");
            int[] end = {Integer.parseInt(inputE[0]), Integer.parseInt(inputE[1])};

            bfs(start[0], start[1], end[0], end[1], visit);
            System.out.println(count);
            count = 0;
        }

    }

    private static void bfs(int startX, int startY, int endX, int endY, boolean[][] visit) {

        Queue<int[]> que = new LinkedList<>();
        if (startX == endX && startY == endY) return;
        if (visit[startX][startY]) return;
        que.offer(new int[]{startX, startY});
        visit[startX][startY] = true;
        int[][] pos = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        int value = 0;
        while (!que.isEmpty()) {
            int[] poll = que.poll();

            for (int i = 0; i < 8; i++) {
                int x = pos[i][0] + poll[0];
                int y = pos[i][1] + poll[1];
                if (x < 0 || x >= m || y < 0 || y >= m) continue;
                if (visit[x][y]) continue;
                if (x == endX && y == endY){
                    count++;
                    return;
                }
                que.offer(new int[]{x, y});
                visit[x][y] = true;
                value++;
            }
            if (value == que.size()) {
                count++;
                value -= que.size();
            }
        }
    }
}
