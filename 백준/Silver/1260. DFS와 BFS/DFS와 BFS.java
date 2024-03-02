import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        boolean[] visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V, visit);
        sb.append("\n");

        bfs();
        sb.append("\n");

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        q.add(V);
        visit[V] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                if (visit[next]) continue;
                q.add(next);
                visit[next] = true;
            }
        }
    }

    private static void dfs(int v, boolean[] visit) {
        if (visit[v]) return;
        visit[v] = true;
        sb.append(v).append(" ");

        for (int i = 0; i < list[v].size(); i++) {
            int next = list[v].get(i);
            if (visit[next]) continue;
            dfs(next, visit);
            visit[next] = true;
        }
    }
}