import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[][] ingredient;
    static int[] pick;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        visit = new boolean[N];
        pick = new int[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            comb(0, 0, i);
        }

        System.out.println(min);
    }

    private static void comb(int start, int cnt, int pickCnt) {
        if (cnt == pickCnt) {
            int sour = 1;
            int bitter = 0;
            for (int i = 0; i < cnt; i++) {
                int[] ing = ingredient[pick[i]];
                sour *= ing[0];
                bitter += ing[1];
            }
            int diff = Math.abs(sour - bitter);
            min = Math.min(diff, min);
            return;
        }

        for (int k = start; k < N; k++) {
            if (visit[k]) continue;
            visit[k] = true;
            pick[cnt] = k;
            comb(k + 1, cnt + 1, pickCnt);
            visit[k] = false;
        }
    }
}