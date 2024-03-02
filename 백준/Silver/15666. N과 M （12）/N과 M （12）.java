import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    static Set<String> picks;
    static int[] pick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        pick = new int[M];
        picks = new LinkedHashSet<>();

        comb(0, 0);

        for (String s : picks) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private static void comb(int start, int cnt) {
        if (cnt == M) {
            StringBuilder str = new StringBuilder();
            for (int i : pick) {
                str.append(i).append(" ");
            }

            picks.add(str.toString());

            return;
        }

        for (int i = start; i < N; i++) {
            pick[cnt] = arr[i];
            comb(i, cnt + 1);
        }
    }
}