import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] arr, pick;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            visit = new boolean[k];
            pick = new int[6];
            int index = 0;
            while (st.hasMoreTokens()) {
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(int start, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < pick.length; i++) {
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            pick[cnt] = arr[i];
            comb(i + 1, cnt + 1);
            visit[i] = false;
        }
    }
}