package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < tCase; t++) {
            int m = Integer.parseInt(br.readLine());
            int[] move = new int[4];
            for (int i = 0; i < 4; i++) {
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");
                move[i] = Integer.parseInt(st.nextToken());
            }

        }
    }
}
