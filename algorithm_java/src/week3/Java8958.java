package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int sum = 0;
            int score = 1;
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                if ("O".equals(str[j])) {
                    sum += score;
                    if (j < str.length - 1)
                        if (str[j + 1].equals("O")) {
                            score++;
                        } else
                            score = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
