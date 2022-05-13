package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[][] array = new String[9][9];

            for (int i = 0; i < 9; i++) {
                array[i] = br.readLine().split(" ");
            }

            int answer = check(array);

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    private static int check(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            boolean[] result = new boolean[9];
            for (int j = 0; j < array.length; j++) {
                if (result[Integer.parseInt(array[i][j]) - 1]) return 0;
                result[Integer.parseInt(array[i][j]) - 1] = true;
            }
        }
        for (int i = 0; i < array.length; i++) {
            boolean[] result = new boolean[9];
            for (int j = 0; j < array.length; j++) {
                if (result[Integer.parseInt(array[j][i]) - 1]) return 0;
                result[Integer.parseInt(array[j][i]) - 1] = true;
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                boolean[] result = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (result[Integer.parseInt(array[3 * k + i][3 * l + j]) - 1]) return 0;
                        result[Integer.parseInt(array[3 * k + i][3 * l + j]) - 1] = true;
                    }
                }
            }
        }
        return 1;
    }
}
