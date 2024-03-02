import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            dp[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (dp[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < list[cur].size(); i++) {
                int n = list[cur].get(i);
                dp[n]--;
                if (dp[n] == 0) {
                    q.offer(n);
                }
            }
        }
        System.out.println(sb);
    }
}