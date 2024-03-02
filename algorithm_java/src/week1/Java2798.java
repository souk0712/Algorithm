package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        String[] rule = br.readLine().split(" ");
        String[] card = br.readLine().split(" ");
        int n = Integer.parseInt(rule[0]);
        int m = Integer.parseInt(rule[1]);

        for (int x = 0; x < n - 2; x++)
            for (int y = x + 1; y < n - 1; y++)
                for (int z = y + 1; z < n; z++) {
                    int sum = Integer.parseInt(card[x]) + Integer.parseInt(card[y]) + Integer.parseInt(card[z]);
                    if (Math.abs(m - result) > Math.abs(m - sum) && sum <= m) {
                        result = sum;
                    }
                }
        System.out.println(result);

    }
}
