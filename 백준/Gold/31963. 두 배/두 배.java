import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = calculate();
        System.out.println(ans);
    }

    private static int calculate() {
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            while (arr[i - 1] > arr[i]) {
                arr[i] *= 2;
                cnt++;
            }
        }
        return cnt;
    }
}