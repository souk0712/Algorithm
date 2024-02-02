import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        int[] time = new int[N + 1];
        int[] d = new int[N + 1];
        int[] ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                list[num].add(i);
                d[i]++;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i < d.length; i++) {
            if (d[i] == 0) {
                q.offer(new int[]{i, time[i]});
                ans[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < list[cur[0]].size(); k++) {
                int next = list[cur[0]].get(k);
                d[next]--;
                if (d[next] == 0) {
                    q.offer(new int[]{next, Math.max(cur[1] + time[next], ans[next])});
                }
                ans[next] = Math.max(cur[1] + time[next], ans[next]);
            }
        }
        for (int a = 1; a < ans.length; a++) {
            System.out.println(ans[a]);
        }
    }
}