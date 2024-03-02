import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[][] start;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        start = new int[2][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    start[index][0] = i;
                    start[index][1] = j;
                    index++;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int[][] temp = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if ((start[0][0] == i && start[0][1] == j) || (start[1][0] == i && start[1][1] == j)) {
                        temp[i][j] = -1;
                    } else {
                        spreadMicroDust(temp, i, j);
                    }
                }
            }
            map = temp;

            cleanAirMachine(start[0][0] + dx[0], start[0][1] + dy[0], 0, 1, 0);
            cleanAirMachine(start[1][0] + dx[0], start[1][1] + dy[0], 0, -1, 0);
        }

        System.out.println(countMap(map));
    }

    private static void cleanAirMachine(int i, int j, int d, int rotate, int nextValue) {
        int mx = i + dx[d];
        int my = j + dy[d];
        int dir = d;

        if (mx < 0 || my < 0 || mx >= R || my >= C) {
            dir = (4 + d + rotate) % 4;
            mx = i + dx[dir];
            my = j + dy[dir];
        }


        int oldValue = map[i][j];
        map[i][j] = nextValue;

        if (map[mx][my] == -1) return;

        cleanAirMachine(mx, my, dir, rotate, oldValue);
    }

    private static void spreadMicroDust(int[][] temp, int i, int j) {
        if (map[i][j] <= 0) return;

        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];
            if (mx < 0 || my < 0 || mx >= R || my >= C) continue;
            if (map[mx][my] == -1) continue;
            count++;
        }

        int around = (map[i][j] / 5);
        int middle = map[i][j] - around * count;
        temp[i][j] += middle;
        for (int k = 0; k < dx.length; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];
            if (mx < 0 || my < 0 || mx >= R || my >= C) continue;
            if (map[mx][my] == -1) continue;
            temp[mx][my] += around;
        }
    }

    private static int countMap(int[][] map) {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    count += map[i][j];
                }
            }
        }
        return count;
    }
}