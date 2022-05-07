package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            boolean three = false;
            String[] str = String.valueOf(i).split("");
            for (int j = 0; j < str.length; j++) {
                switch (str[j]) {
                    case "3":
                    case "6":
                    case "9":
                        three = true;
                        sb.append("-");
                        break;
                }
            }
            if (!three) {
                sb.append(i + " ");
            } else {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
