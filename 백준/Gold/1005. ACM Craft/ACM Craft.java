import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] D, dp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            D = new int[N + 1];
            dp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                list[to].add(from);
                dp[from]++;
            }
            int node = Integer.parseInt(br.readLine());

            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
            for (int i = 1; i < dp.length; i++) {
                if (dp[i] == 0) {
                    q.offer(new int[]{i, D[i]});
                }
            }
            int ans = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == node) {
                    ans = Math.max(ans, cur[1]);
                }
                for (int i = 0; i < list[cur[0]].size(); i++) {
                    int n = list[cur[0]].get(i);
                    dp[n]--;
                    if (dp[n] == 0) {
                        q.offer(new int[]{n, cur[1] + D[n]});
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}