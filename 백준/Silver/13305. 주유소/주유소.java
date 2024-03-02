import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N - 1];
        int[] price = new int[N];
        int min = Integer.MAX_VALUE;
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            if (i != N - 1)
                min = Math.min(min, price[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            if (price[i] == min) {
                int sum = 0;
                for (int j = i; j < N - 1; j++) {
                    sum += length[j];
                }
                ans += price[i] * sum;
                break;
            } else {
                ans += length[i] * price[i];
            }
        }

        System.out.println(ans);
    }
}