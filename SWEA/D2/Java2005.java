package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2005 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int colum = N;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < colum; j++) {
                    if (i == 0 || j == 0) {
                        map[i][j] = 1;
                        continue;
                    }
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
                colum--;
            }
            System.out.println("#" + (t + 1));
            printResult(map);
        }
    }

    private static void printResult(int[][] map) {
        for (int k = 0; k < map.length; k++) {
            System.out.print(map[k][0] + " ");
            for (int m = 0; m < k + 1; m++) {
                int x = k - (m + 1);
                int y = (m + 1);
                if (x < 0 || x >= N || y >= N) {
                    System.out.println();
                    continue;
                }
                System.out.print(map[x][y] + " ");

            }
        }
    }
}
