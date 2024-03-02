package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java17204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int j = 0;
        int count = 0;
        boolean[] check = new boolean[n];
        while (j != k) {
            count++;
            j = arr[j];

            if (check[j]) {
                System.out.println(-1);
                return;
            }
            check[j] = true;
        }
        System.out.println(count);

    }
}