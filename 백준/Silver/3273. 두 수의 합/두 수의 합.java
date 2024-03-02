import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int X = Integer.parseInt(br.readLine());
        int ans = 0;
        Arrays.sort(arr);
        int left = 0, right = N - 1;
        int sum = arr[left] + arr[right];
        while (left < right) {
            if (sum == X) {
                ans++;
            }

            if (sum <= X) {
                sum -= arr[left];
                sum += arr[++left];
            } else {
                sum -= arr[right];
                sum += arr[--right];
            }
        }
        System.out.println(ans);
    }
}