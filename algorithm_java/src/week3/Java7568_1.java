package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java7568_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grade = new int[n];
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < n; j++) {
            grade[j] = 1;
            for (int a = 0; a < n; a++) {
                if (x[j] < x[a]) {
                    if (y[j] < y[a]) {
                        grade[j] += 1;
                    }
                }
            }
            System.out.print(grade[j]+" ");
        }
    }
}

