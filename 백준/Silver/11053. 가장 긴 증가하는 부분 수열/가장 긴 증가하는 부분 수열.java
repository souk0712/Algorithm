import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(dp, arr[i]);
            if (idx < 0) {
                idx = (idx + 1) * -1;
            }
            if (idx >= dp.size()) {
                dp.add(arr[i]);
            } else {
                dp.set(idx, arr[i]);
            }
        }
        System.out.println(dp.size());
    }
}