package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int count = 0;
        for (int level = 0; level < n; level++) {
            score[level] = Integer.parseInt(br.readLine());
        }
        for (int i = score.length - 1; 0 < i; i--) {
            int compare = score[i];
            while (compare <= score[i - 1]) {
                score[i - 1] -= 1;
                count++;
            }
        }
        System.out.println(count);
    }

}