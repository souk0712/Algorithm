import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] relation;
    static int[] answer;
    private static final int INF = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        relation = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) relation[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (relation[i][j] > relation[i][k] + relation[k][j]) {
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer[i] = Math.max(answer[i], relation[i][j]);
            }
        }

        int min = INF;
        ArrayList<Integer> minList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (min > answer[i]) {
                min = answer[i];
                minList = new ArrayList<>();
            }
            if (min == answer[i]) {
                minList.add(i);
            }
        }

        sb.append(min).append(" ").append(minList.size()).append("\n");
        for (int m : minList) {
            sb.append(m).append(" ");
        }

        System.out.println(sb);
    }
}