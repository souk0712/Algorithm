import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = Long.parseLong(br.readLine());   //1_000_000_000_000_000
        StringBuilder sb = new StringBuilder();
        Set<Pair> set = new TreeSet<>();
        // nCr = nC(n-r)
        // r <= n-r
        // r이 n/2일때, 가장 큰 값을 가진다. => 2*r = n
        // r 결정
        for (long r = 1; r < 31; r++) {
            long start = 1;
            long end = M;
            // n 결정
            while (start <= end) {
                long mid = (start + end) / 2;
                long res = nCr(mid, r);
                if (res == M) {
                    set.add(new Pair(mid, r));
                    set.add(new Pair(mid, mid - r));
                    break;
                } else if (res < M) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        sb.append(set.size()).append("\n");
        for (Pair p : set) {
            sb.append(p.n).append(" ").append(p.k).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static long nCr(long n, long r) {
        // nCr = (n * n-1 * n-2 * ... * n-r+2 * n-r+1) / (r * r-1 * r-2 * ... * 1)
        double res = n - r + 1;
        for (int i = 2; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return (long) res;
    }

    static class Pair implements Comparable<Pair> {
        long n, k;

        Pair(long n, long k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public int compareTo(Pair o) {
            int com = Long.compare(n, o.n);
            if (com == 0) {
                return Long.compare(k, o.k);
            } else {
                return com;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Pair) {
                Pair p = (Pair) obj;
                return p.n == n && p.k == k;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, k);
        }
    }
}