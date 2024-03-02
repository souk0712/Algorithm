import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, res;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        res = 0;
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        visited[1] = true;
        virus(1);

        System.out.println(res);
    }

    private static void virus(int start) {
        ArrayList<Integer> tmp = list[start];

        for (int i = 0; i < tmp.size(); i++) {
            int a = tmp.get(i);
            if (visited[a]) continue;

            visited[a] = true;
            res++;
            virus(a);
        }
    }
}