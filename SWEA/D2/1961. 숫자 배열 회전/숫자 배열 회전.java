import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append("#").append(t + 1).append("\n");
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] rotate90 = new int[N][N];
            int[][] rotate180 = new int[N][N];
            int[][] rotate270 = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rotate(map, rotate90);
            rotate(rotate90, rotate180);
            rotate(rotate180, rotate270);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(rotate90[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(rotate180[i][j]);
                }
                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(rotate270[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void rotate(int[][] map, int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[j][N - 1 - i] = map[i][j];
            }
        }
    }
}