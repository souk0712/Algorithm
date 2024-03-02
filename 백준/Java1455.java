package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int count = 0;
        boolean[][] map = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            String[] str = br.readLine().split("");
            for (int m = 0; m < M; m++) {
                if (str[m].equals("0")) map[n][m] = false;
                else if (str[m].equals("1")) map[n][m] = true;
            }
        }
        boolean check = true;
        while (check) {
            for (int i = N-1; i >= 0; i--) {
                for (int j = M-1; j >=0 ; j--) {
                    if (map[i][j]) {
                        for (int k = i; k >= 0; k--) {
                            for (int a = j; a >= 0; a--) {
                                map[k][a] = !map[k][a];
                            }
                        }
                        count++;
                    }
                }
            }
            loop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j]) break loop;
                    check = false;
                }

            }
        }
        System.out.println(count);
    }
}
