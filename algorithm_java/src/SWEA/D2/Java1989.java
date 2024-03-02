package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            int size = input.length;
            int result = 1;
            for (int j = 0; j < input.length / 2; j++) {
                if (!input[j].equals(input[size - j - 1]))
                    result = 0;
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}