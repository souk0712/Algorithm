package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        int r = 0;
        int c = 0;
        int pt = 0;
        String[][] array = {};

        for (int i = 1; i <= 100; i++)
            for (int j = 1; j <= 100; j++) {
                if (i * j == n.length && i <= j)
                    if (r < i) {
                        r = i;
                        c = j;
                        array = new String[r][c];
                    }
            }

        for (int j = 0; j < c; j++)
            for (int i = 0; i < r; i++) {
                array[i][j] = n[pt++];
            }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                System.out.print(array[i][j]);
            }
        System.out.println();
    }
}
