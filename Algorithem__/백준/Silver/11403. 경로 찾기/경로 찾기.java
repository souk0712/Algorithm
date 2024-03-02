import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        res = new int[N][N];
        ArrayList<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int isPath = Integer.parseInt(st.nextToken());
                if (isPath == 1) {
                    list[i].add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            boolean[] visit = new boolean[N];
            dfs(list, i, i, visit);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] i : res) {
            for (int ii : i) {
                sb.append(ii).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(ArrayList<Integer>[] list, int x, int y, boolean[] visit) {
        for (int j = 0; j < list[y].size(); j++) {
            int n = list[y].get(j);
            if (visit[n]) continue;
            visit[n] = true;
            res[x][n] = 1;
            dfs(list, x, n, visit);
        }
    }
}