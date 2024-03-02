import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Position> list;
    static int N, M, L, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Position(x, y));
        }

        int ans = Integer.MIN_VALUE;

        for (Position starX : list) {
            for (Position starY : list) {
                ans = Math.max(ans, boundStart(starX.x, starY.y));
            }
        }

        System.out.println(K - ans);
    }

    private static int boundStart(int x, int y) {
        int count = 0;
        for (Position p : list) {
            if (x <= p.x && x + L >= p.x && y <= p.y && y + L >= p.y) {
                count++;
            }
        }
        return count;
    }

    public static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}