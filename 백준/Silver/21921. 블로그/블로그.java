import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        long max = Long.MIN_VALUE;
        long sum = arr[0];
        int len = 1;
        int left = 0, right = 0;
        while (left <= right) {
            if (right < N - 1 && len <= X) {
                sum += arr[++right];
                len++;
            } else {
                sum -= arr[left++];
                len--;
            }

            if (len == X) {
                if (max < sum) {
                    max = sum;
                    cnt = 1;
                } else if (max == sum) {
                    cnt++;
                }
            }
        }

        if (max == 0) {
            sb.append("SAD");

        } else {
            sb.append(max).append("\n").append(cnt);
        }

        System.out.println(sb);
    }
}