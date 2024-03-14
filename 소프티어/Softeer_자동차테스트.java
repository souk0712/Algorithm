package lan_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Softeer_자동차테스트 {

    static int N, Q;
    static int[] arr, ans;
    static int[] m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        m = new int[Q];
        ans = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < Q; i++) {
            m[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < Q; i++) {
            int idx = binarySearch(m[i], 0, N - 1, N);
            if (idx != -1) {
                ans[i] = idx * (N - 1 - idx);
            }
        }

        for (int a : ans) {
            System.out.println(a);
        }
    }

    static int binarySearch(int target, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                res = mid;
            }
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start == size ? -1 : res;
    }
}
