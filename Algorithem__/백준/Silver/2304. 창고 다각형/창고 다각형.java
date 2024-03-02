import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int maxIndex;
    static Block[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Block[N];
        maxIndex = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[i] = new Block(L, H);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].H > max) {
                max = arr[i].H;
                maxIndex = i;
            }
        }

        System.out.println(up() + max + down());
    }

    private static int down() {
        int sum = 0;
        Block temp = arr[N - 1];
        for (int i = N - 2; i >= maxIndex; i--) {
            Block a = arr[i];
            if (temp.H <= a.H) {
                sum += (temp.L - a.L) * temp.H;
                temp = a;
            }
        }

        return sum;
    }

    private static int up() {
        int sum = 0;
        Block temp = arr[0];
        for (int i = 1; i <= maxIndex; i++) {
            Block a = arr[i];
            if (temp.H <= a.H) {
                sum += (a.L - temp.L) * temp.H;
                temp = a;
            }
        }

        return sum;
    }

    static class Block implements Comparable<Block> {
        int L, H;

        Block(int L, int H) {
            this.L = L;
            this.H = H;
        }

        @Override
        public int compareTo(Block o) {
            if (L == o.L) {
                return Integer.compare(H, o.H);
            } else {
                return Integer.compare(L, o.L);
            }
        }
    }
}