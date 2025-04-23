import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree, lazy;
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[n];
        tree = new long[n * 4];
        lazy = new long[n * 4];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        build(arr, 1, 0, n - 1);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                updateRange(1, 0, n - 1, b - 1, c - 1, d);
            } else {
                sb.append(query(1, 0, n - 1, b - 1, c - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void build(long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, node * 2, start, mid);
        build(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void updateRange(int node, int start, int end, long left, long right, long val) {
        updateLazy(node, start, end);
        if (right < start || left > end) {
            return;
        }
        if (left <= start && right >= end) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }
        int mid = (start + end) / 2;
        updateRange(node * 2, start, mid, left, right, val);
        updateRange(node * 2 + 1, mid + 1, end, left, right, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static void updateLazy(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static long query(int node, int start, int end, long left, long right) {
        updateLazy(node, start, end);
        if (right < start || end < left) return 0;
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }
}