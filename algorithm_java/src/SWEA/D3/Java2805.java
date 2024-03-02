package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2805 {
    static int count = 1;
    static int N;
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            /** String을 int 배열로 받는 방법.(띄어쓰기 구분아닐 때)
             int[][] farm = new int[n][n];
             for (int i = 0; i< n;i++){
                 char[] str = br.readLine().toCharArray();
                 for(int j = 0; j < n; j++) {
                     farm[i][j] = str[j]-'0';
                 }
             }
             **/
            String[][] farm = new String[N][N];
            for (int i = 0; i < N; i++) {
                farm[i] = br.readLine().split("");
            }
            int half = N / 2;
            int x = 0;
            int y = half;
            if (half == 0) {
                value = Integer.parseInt(farm[x][y]);
            } else {
                value += Integer.parseInt(farm[x][y]);
                fun1(farm, x, y, half);
            }
            System.out.println("#" + (t + 1) + " " + value);
            value = 0;
            count = 1;
        }
    }

    private static void fun1(String[][] farm, int x, int y, int half) {
        count += 2;
        int[] pos = {1, -1};
        int mX = x + pos[0];
        int mY = y + pos[1];
        int befY = mY;
        for (int i = 0; i < count; i++) {
            value += Integer.parseInt(farm[mX][mY++]);
        }
        if (mX < 0 || mX >= N || mY < 0 || mY >= N) {
            fun2(farm, mX, befY, half);
            return;
        }
        fun1(farm, mX, befY, half);
    }

    private static void fun2(String[][] farm, int x, int y, int half) {
        count -= 2;
        int[] pos = {1, 1};
        int mX = x + pos[0];
        int mY = y + pos[1];
        int befY = mY;

        for (int i = 0; i < count; i++) {
            value += Integer.parseInt(farm[mX][mY++]);
        }
        if (half == befY) return;
        fun2(farm, mX, befY, half);
    }
}