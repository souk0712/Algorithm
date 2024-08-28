import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ans;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][4];
        ans = Integer.MIN_VALUE;
        Fish[] fishes = new Fish[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int id = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = id;
                fishes[id] = new Fish(id, i, j, dir, false);
            }
        }
        moveJaws(0, 0, 0, map, fishes);

        System.out.println(ans);
    }

    private static void moveJaws(int i, int j, int total, int[][] map, Fish[] fishes) {
        int id = map[i][j];
        total += id;
        int dir = fishes[id].dir;
        fishes[id].dead = true;
        ans = Math.max(ans, total);

        moveFish(i, j, map, fishes);

        for (int k = 1; k < 4; k++) {
            int mx = i + k * dx[dir];
            int my = j + k * dy[dir];
            if (checkRangeOut(mx, my) || fishes[map[mx][my]].dead) continue;
            Fish[] tempFishes = copyFish(fishes);
            int[][] tempMap = copyMap(map);
            moveJaws(mx, my, total, map, fishes);
            map = tempMap;
            fishes = tempFishes;
        }
    }

    private static Fish[] copyFish(Fish[] fishes) {
        Fish[] newFishes = new Fish[17];
        for (int i = 1; i < newFishes.length; i++) {
            Fish fish = fishes[i];
            newFishes[i] = new Fish(fish.id, fish.x, fish.y, fish.dir, fish.dead);
        }
        return newFishes;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] res = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res[i][j] = map[i][j];
            }
        }
        return res;
    }

    private static void moveFish(int jx, int jy, int[][] map, Fish[] fishes) {
        for (int i = 1; i <= 16; i++) {
            Fish fish = fishes[i];
            if (fish.dead) continue;
            int cnt = 0;
            while (cnt < dx.length) {
                int mx = fish.x + dx[fish.dir % dx.length];
                int my = fish.y + dy[fish.dir % dx.length];
                if (checkRangeOut(mx, my) || (mx == jx && my == jy)) {
                    fish.dir = (fish.dir + 1) % dx.length;
                    cnt++;
                    continue;
                }
                if (map[mx][my] >= 0) {
                    swap(map, mx, my, fish.x, fish.y, fishes);
                    break;
                }
            }
        }
    }

    private static void swap(int[][] map, int x1, int y1, int x2, int y2, Fish[] fishes) {
        Fish lf = fishes[map[x1][y1]];
        Fish rf = fishes[map[x2][y2]];
        map[x1][y1] = rf.id;
        map[x2][y2] = lf.id;
        lf.x = x2;
        lf.y = y2;
        rf.x = x1;
        rf.y = y1;
    }

    private static boolean checkRangeOut(int mx, int my) {
        return mx < 0 || my < 0 || mx >= 4 || my >= 4;
    }

    static class Fish {
        int id, x, y, dir;
        boolean dead;

        Fish(int id, int x, int y, int dir, boolean dead) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dead = dead;
        }
    }
}