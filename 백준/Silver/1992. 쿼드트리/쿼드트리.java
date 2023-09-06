import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);
    }

    private static void quadTree(int x, int y, int size) {

        if (check(x, y, size)) {
            sb.append(map[x][y]);
        } else {
            sb.append("(");
            int mSize = size / 2;
            quadTree(x, y, mSize);
            quadTree(x, y + mSize, mSize);
            quadTree(x + mSize, y, mSize);
            quadTree(x + mSize, y + mSize, mSize);
            sb.append(")");
        }
    }

    public static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x][y] != map[i][j])
                    return false;
            }
        }
        return true;
    }
}