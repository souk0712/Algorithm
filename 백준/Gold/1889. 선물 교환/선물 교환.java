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
        int[] in = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i].add(a);
            list[i].add(b);
            in[a]++;
            in[b]++;
        }
        topologySort(N, in, list);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (in[i] == 2) {
                ans.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (ans.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(ans.size()).append("\n");
            for (int i : ans) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void topologySort(int N, int[] in, ArrayList<Integer>[] list) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (in[i] < 2) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                in[next]--;
                if (in[next] < 2) {
                    q.offer(next);
                }
            }
        }
    }
}