package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] array = new int[N][N];
            int[][] rotate90 = new int[N][N];
            int[][] rotate180 = new int[N][N];
            int[][] rotate270 = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rotate(N, array, rotate90);
            rotate(N, rotate90, rotate180);
            rotate(N, rotate180, rotate270);

            System.out.println("#" + (t + 1));

            for (int i = 0; i < array.length; i++) {
                answerP(rotate90,i);
                answerP(rotate180,i);
                answerP(rotate270,i);
                System.out.println();
            }
        }
    }

    private static void answerP(int[][] rotated, int i) {
        for (int j = 0; j < rotated.length; j++) {
            System.out.print(rotated[i][j]);
        }
        System.out.print(" ");

    }

    private static void rotate(int N, int[][] array, int[][] rotated) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N-1-i] = array[i][j];
            }
        }
    }
}
/**
 * 행렬 회전
 * [x, y] => [y, (N - 1) - x]
 */