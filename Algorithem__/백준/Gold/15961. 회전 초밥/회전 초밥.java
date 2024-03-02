import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] kind = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE, count = 0;

        for (int i = 0; i < k; i++) {
            if (kind[arr[i]] == 0) count++;
            kind[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            
            kind[arr[i]]--;
            if (kind[arr[i]] == 0) {
                count--;
            }

            int idx = arr[(i + k) % N];
            if (kind[idx] == 0) {
                count++;
            }
            kind[idx]++;

            if (kind[c] == 0) {
                max = Math.max(max, count + 1);
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}