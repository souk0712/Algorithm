import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] inorder, postorder, index;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        index = new int[N + 1];
        inorder = new int[N];
        postorder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            index[inorder[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preorder(0, N - 1, 0, N - 1);

        System.out.println(sb);
    }

    private static void preorder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;

        int root = postorder[pe];
        sb.append(postorder[pe]).append(" ");
        int idx = index[root];
        
        preorder(is, idx - 1, ps, ps + idx - 1 - is);
        preorder(idx + 1, ie, ps + idx - is, pe - 1);
    }
}