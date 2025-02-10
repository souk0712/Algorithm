import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] preOrder;
    static int[] inOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            preOrder = new int[N];
            inOrder = new int[N];
            for (int i = 0; i < N; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }

            getPostOrder(sb, 0, N, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void getPostOrder(StringBuilder sb, int s, int e, int cur) {
        for (int i = s; i < e; i++) {
            if (preOrder[cur] == inOrder[i]) {
                getPostOrder(sb, s, i, cur + 1);
                getPostOrder(sb, i + 1, e, cur + i + 1 - s);
                sb.append(preOrder[cur]).append(" ");
            }
        }
    }
}