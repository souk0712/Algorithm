import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static ArrayList<int[]> apples;
    static Map<Integer, Character> rotate;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        apples = new ArrayList<>();
        rotate = new HashMap<>();
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            apples.add(new int[]{x, y});
            map[x][y] = -1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char y = st.nextToken().charAt(0);
            rotate.put(x, y);
        }

        System.out.println(start());
    }

    private static int start() {
        map[0][0] = 1;
        int dir = 0;
        int time = 0;
        int[] head = {0, 0};
        int[] tail = {0, 0};
        while (true) {
            int mx = head[0] + dx[dir];
            int my = head[1] + dy[dir];
            if (checkRange(mx, my)) {
                return time + 1;
            }
            if (map[mx][my] != -1) {
                if (map[mx][my] != 0) {
                    return time + 1;
                } else {
                    int d = map[tail[0]][tail[1]] - 1;
                    map[tail[0]][tail[1]] = 0;
                    int tx = tail[0] + dx[d];
                    int ty = tail[1] + dy[d];
                    tail = new int[]{tx, ty};
                }
            }
            head = new int[]{mx, my};
            time++;
            if (rotate.containsKey(time)) {
                char c = rotate.get(time);
                if (c == 'D') {
                    dir = (dir + 1) % 4;
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                }
            }
            map[mx][my] = dir + 1;
        }
    }

    private static boolean checkRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}