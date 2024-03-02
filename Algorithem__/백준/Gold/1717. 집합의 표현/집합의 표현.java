import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        union = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            union[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] operArr = new int[3];

            for (int j = 0; j < 3; j++) {
                operArr[j] = Integer.parseInt(st.nextToken());
            }

            if (operArr[0] == 0) {
                Union(operArr[1], operArr[2]);
            } else {
                if (find(operArr[1]) == find(operArr[2])) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int x) {
        if (union[x] == x) return x;
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