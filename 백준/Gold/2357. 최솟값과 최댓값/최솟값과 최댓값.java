import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] minTree, maxTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minTree = new long[n * 4];
        maxTree = new long[n * 4];
        for (int i = 0; i < n * 4; i++) {
            minTree[i] = Long.MAX_VALUE;
            maxTree[i] = Long.MIN_VALUE;
        }
        arr = new long[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        buildMaxTree(1, 0, n - 1);
        buildMinTree(1, 0, n - 1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken()) - 1;
            long min = queryMinTreeValue(minTree, 1, 0, n - 1, a, b);
            long max = queryMaxTreeValue(maxTree, 1, 0, n - 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static long queryMinTreeValue(long[] tree, int node, long start, long end, long left, long right) {
        if (right < start || end < left) return Long.MAX_VALUE;
        if (left <= start && right >= end) return tree[node];
        long mid = start + (end - start) / 2;
        return Math.min(queryMinTreeValue(tree, node * 2, start, mid, left, right), queryMinTreeValue(tree, node * 2 + 1, mid + 1, end, left, right));
    }

    private static long queryMaxTreeValue(long[] tree, int node, long start, long end, long left, long right) {
        if (right < start || end < left) return Long.MIN_VALUE;
        if (left <= start && right >= end) return tree[node];
        long mid = start + (end - start) / 2;
        return Math.max(queryMaxTreeValue(tree, node * 2, start, mid, left, right), queryMaxTreeValue(tree, node * 2 + 1, mid + 1, end, left, right));
    }

    static void buildMaxTree(int node, int start, int end) {
        if (start == end) {
            maxTree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildMaxTree(node * 2, start, mid);
        buildMaxTree(node * 2 + 1, mid + 1, end);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static void buildMinTree(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildMinTree(node * 2, start, mid);
        buildMinTree(node * 2 + 1, mid + 1, end);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }
}