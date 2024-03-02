import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] input = new int[M];
        union = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            union[i] = i;
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    Union(i, j);
            }
        }

        int index = 0;
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            input[index++] = Integer.parseInt(st.nextToken());
        }

        boolean check = true;

        for (int i = 0; i < M - 1; i++) {
            if (union[input[i]] != union[input[i + 1]]) {
                check = false;
                break;
            }
        }

        if (check) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int find(int x) {
        if (x == union[x]) return x;
        return union[x] = find(union[x]);
    }

    private static void Union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return;
        if (a < b) union[b] = a;
        else union[a] = b;
    }
}