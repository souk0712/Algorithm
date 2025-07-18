import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int N;
    static int[][] mosquito;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        TreeSet<Integer> time = new TreeSet<>();
        mosquito = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mosquito[i][0] = Integer.parseInt(st.nextToken());
            mosquito[i][1] = Integer.parseInt(st.nextToken());
            time.add(mosquito[i][0]);
            time.add(mosquito[i][1]);
        }
        ArrayList<Integer> sorted = new ArrayList<>(time);
        int[] sum = new int[sorted.size()];
        for (int i = 0; i < N; i++) {
            int ts = Collections.binarySearch(sorted, mosquito[i][0]);
            int te = Collections.binarySearch(sorted, mosquito[i][1]);
            for (int j = ts; j < te; j++) {
                sum[j]++;
            }
        }

        int max = 0, idx = 0, idxEnd = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > max) {
                idx = i;
                max = sum[i];
                idxEnd = i;
            }
            if (sum[i] == max && i - 1 == idxEnd) {
                idxEnd = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(sorted.get(idx)).append(" ").append(sorted.get(idxEnd + 1));
        System.out.println(sb);
    }
}