package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split("");

            int answer = cycleCheck(input);
            System.out.println("#" + (t + 1) + " " + (answer + 1));
        }
    }

    private static int cycleCheck(String[] input) {
        int[] a = new int[input.length];
        loop:
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i].equals(input[j])) {
                    continue loop;
                } else {
                    a[i]++;
                }

            }
        }

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }
}
