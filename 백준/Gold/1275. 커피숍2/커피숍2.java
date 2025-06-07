import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        tree = new long[n * 4];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        buildTree(arr, 1, 0, n - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            if (x <= y) {
                sb.append(queryTree(1, 0, n - 1, x, y));
            } else {
                sb.append(queryTree(1, 0, n - 1, y, x));
            }
            sb.append("\n");
            updateTree(1, 0, n - 1, a, b);
        }
        System.out.println(sb);
    }

    static void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(arr, node * 2, start, mid);
        buildTree(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (mid >= idx) {
            updateTree(node * 2, start, mid, idx, val);
        } else {
            updateTree(node * 2 + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long queryTree(int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        if (start >= left && right >= end) return tree[node];
        int mid = start + (end - start) / 2;
        return queryTree(node * 2, start, mid, left, right) + queryTree(node * 2 + 1, mid + 1, end, left, right);
    }
}