import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] start, dest;
    static int[][] comb;
    static boolean[] visit;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            start = new int[2];
            dest = new int[2];
            comb = new int[n][2];
            check = false;
            visit = new boolean[n];
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                comb[i][0] = Integer.parseInt(st.nextToken());
                comb[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());
            dfs(start[0], start[1]);
            if (check) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        if (x == dest[0] && y == dest[1]) {
            check = true;
            return;
        }

        for (int i = 0; i < comb.length; i++) {
            int[] nextComb = comb[i];
            int diff = getDiff(x, y, nextComb[0], nextComb[1]);
            if (!visit[i] && isEnoughBeer(diff)) {
                visit[i] = true;
                dfs(nextComb[0], nextComb[1]);
            }
        }
        int d = getDiff(x, y, dest[0], dest[1]);
        if (isEnoughBeer(d)) {
            dfs(dest[0], dest[1]);
        }
    }

    private static boolean isEnoughBeer(int diff) {
        int n = diff / 50;
        if (n == 20) {
            return diff % 50 == 0;
        } else return n < 20;
    }

    private static int getDiff(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}