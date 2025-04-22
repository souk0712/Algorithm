import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new long[N * 4];
        long[] arr = new long[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        buildTree(arr, 1, 0, N - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                updateTree(1, 0, N - 1, b - 1, c);
            } else {
                sb.append(queryTree(1, 0, N - 1, b - 1, c - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void buildTree(long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + ((end - start) / 2);
        buildTree(arr, node * 2, start, mid);
        buildTree(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2 + 1] + tree[node * 2];
    }

    static void updateTree(int node, int start, int end, long idx, long val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + ((end - start) / 2);
        if (mid >= idx) {
            updateTree(node * 2, start, mid, idx, val);
        } else {
            updateTree(node * 2 + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[node * 2 + 1] + tree[node * 2];
    }

    static long queryTree(int node, int start, int end, long left, long right) {
        if (right < start || end < left) return 0;
        if (left <= start && right >= end) return tree[node];
        int mid = start + ((end - start) / 2);
        return queryTree(node * 2, start, mid, left, right) + queryTree(node * 2 + 1, mid + 1, end, left, right);
    }
}