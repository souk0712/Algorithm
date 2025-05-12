import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static int[] in, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        in = new int[n + 1];
        ans = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            in[b]++;
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(new int[]{i, 1});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ans[cur[0]] = cur[1];

            for (int k = 0; k < list[cur[0]].size(); k++) {
                int next = list[cur[0]].get(k);
                if (--in[next] == 0) {
                    q.offer(new int[]{next, cur[1] + 1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}