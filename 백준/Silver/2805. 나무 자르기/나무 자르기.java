import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long ans = 0;
        int start = 0, end = 2_000_000_000;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (determination(mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static boolean determination(long H) {
        long slice = 0;
        for (int tree : trees) {
            if (tree > H) {
                slice += tree - H;
            }
        }
        return slice >= M;
    }
}