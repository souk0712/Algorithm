import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int ans = 0;
        int sum = 0;
        int weight = 1;
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c == '*') {
                if (i % 2 == 1) {
                    weight = 3;
                }
            } else {
                int digit = isbn.charAt(i) - '0';
                if (i % 2 == 1) {
                    digit *= 3;
                }
                sum += digit;
            }
        }
        for (int k = 0; k < 10; k++) {
            if ((sum + weight * k) % 10 == 0) {
                ans = k;
            }
        }
        System.out.println(ans);
    }
}