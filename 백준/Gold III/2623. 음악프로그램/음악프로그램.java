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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] d = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        ArrayList<Integer>[] pd = new ArrayList[M];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < pd.length; i++) {
            pd[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                pd[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < pd[i].size() - 1; j++) {
                int to = pd[i].get(j);
                int from = pd[i].get(j + 1);
                list[to].add(from);
                d[from]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visit[cur]) continue;
            visit[cur] = true;
            sb.append(cur).append("\n");

            for (int k = 0; k < list[cur].size(); k++) {
                int n = list[cur].get(k);
                if (visit[n]) continue;
                if (--d[n] == 0) {
                    q.offer(n);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (d[i] != 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);
    }
}