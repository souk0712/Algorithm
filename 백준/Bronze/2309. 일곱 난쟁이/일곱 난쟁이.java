import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] pick, height, ans;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        pick = new int[7];
        ans = new int[7];
        visit = new boolean[9];
        comb(0, 0);
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static void comb(int start, int cnt) {
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += pick[i];
            }
            if (sum == 100) {
                System.arraycopy(pick, 0, ans, 0, 7);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            if (visit[i]) continue;
            pick[cnt] = height[i];
            visit[i] = true;
            comb(i + 1, cnt + 1);
            visit[i] = false;
        }
    }
}