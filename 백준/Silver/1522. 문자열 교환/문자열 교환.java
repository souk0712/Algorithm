import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int min = Integer.MAX_VALUE;
        int a_len = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') a_len++;
        }

        int initLen = input.length();

        int left = 0, right = 0;
        int b_len = 0;
        int len = 1;

        if (input.charAt(0) == 'b') {
            b_len++;
        }

        while (left < initLen) {
            if (len <= a_len) {
                char r = input.charAt(++right % initLen);
                if (r == 'b') b_len++;
                len++;
            } else {
                char l = input.charAt(left++);
                if (l == 'b') b_len--;
                len--;
            }

            if (len == a_len) {
                min = Math.min(min, b_len);
            }
        }

        System.out.println(min);
    }
}