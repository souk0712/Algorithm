import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, min;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            list = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            for (int m = 0; m < M; m++) {
                String[] str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);

                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= N; i++) {
                Airplane(i);
            }

            System.out.println(min - 1);
        }
    }

    private static void Airplane(int start) {
        min = 0;
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            min++;
            for (int k = 0; k < list[cur].size(); k++) {
                int x = list[cur].get(k);
                if (visited[x]) continue;
                q.offer(x);
                visited[x] = true;
            }
        }
    }
}