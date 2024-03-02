import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        ArrayList<Integer>[] list = new ArrayList[N];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(list[j]);
                        list[i] = tmp;
                    }
                }
            }
            list[i].add(arr[i]);
            if (max < dp[i]) {
                max = dp[i];
                ans = list[i];
            }
        }
        sb.append(max).append("\n");
        for (int a : ans) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}