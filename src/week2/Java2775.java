package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apart = new int[k+1][n];
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        apart[i][j] = j + 1;
                    } else {
                        if (j == 0) {
                            apart[i][j] = 1;
                        } else {
                            apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
                        }
                    }
                }
            }
            System.out.println(apart[k][n-1]);
        }
    }
}
/**
 * 1차원 배열
 * int[] array1 = new int[5];
 * int[] array1 = {1,2,3,4};
 * 2차원 배열
 * int[][] array2 = new int[2][3];
 * int[][] array2 = {{1,2,3},{4,5,6}};
 */