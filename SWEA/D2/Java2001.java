package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1:17 ~ 1:50
public class Java2001 {
    static int N;
    static int M;
    static int sumIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s, " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] sum = new int[(N - 1) * (N - 1)];

            sumIndex = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    sumMap(i, j, map, sum);
                }
            }
            int max = 0;
            for (int i = 0; i < sum.length; i++) {
                if (max < sum[i]) {
                    max = sum[i];
                }
            }
            System.out.println("#" + (t + 1) + " " + max);
        }
    }

    private static void sumMap(int i, int j, int[][] map, int[] sum) {
        for (int k = 0; k < M; k++) {
            for (int l = 0; l < M; l++) {
                sum[sumIndex] += map[i + k][j + l];
            }
        }
        sumIndex++;
    }
}