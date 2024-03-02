import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2644_촌수계산 {
    static int n, m, answer;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 전체 사람 수
        target = new int[2]; // 촌수 계산해야 하는 서로 다른 수
        String[] str = br.readLine().split(" ");
        target[0] = Integer.parseInt(str[0]);
        target[1] = Integer.parseInt(str[1]);
        answer = -1;
        boolean[] visit = new boolean[n + 1];
        m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            list[from].add(to);
            list[to].add(from);
        }
        dfs(target[0], list, visit, 0);
        System.out.println(answer);
    }

    private static void dfs(int node, ArrayList<Integer>[] list, boolean[] visit, int cnt) {
        if (visit[node])
            return;
        if (node == target[1]) {
            answer = cnt;
        }
        visit[node] = true;
        for (int i = 0; i < list[node].size(); i++) {
            int value = list[node].get(i);
            if (visit[value]) continue;
            dfs(value, list, visit, cnt + 1);
        }
    }
}
