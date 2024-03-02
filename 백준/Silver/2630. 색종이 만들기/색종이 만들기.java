import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, blue, white;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        blue = 0;
        white = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, N);

        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    private static void cutPaper(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (map[x][y] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int nSize = size / 2;

        cutPaper(x, y, nSize);
        cutPaper(x, y + nSize, nSize);
        cutPaper(x + nSize, y, nSize);
        cutPaper(x + nSize, y + nSize, nSize);
    }

    private static boolean colorCheck(int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}