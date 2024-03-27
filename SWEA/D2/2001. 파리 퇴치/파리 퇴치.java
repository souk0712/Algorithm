import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, ans;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i <= N - M; i++) {
                int sum = init(i);
                ans = Math.max(ans, sum);
                for (int j = 0; j < N - M; j++) {
                    for (int k = i; k < i + M; k++) {
                        sum -= map[k][j];
                    }
                    for (int k = i; k < i + M; k++) {
                        sum += map[k][j + M];
                    }
                    ans = Math.max(ans, sum);
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int init(int x) {
        int sum = 0;
        for (int i = x; i < x + M; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}