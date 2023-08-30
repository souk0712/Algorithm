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

        for (int i = 0; i < input.length(); i++) {
            int b_cnt = 0;
            for (int j = i; j < a_len + i; j++) {
                if (input.charAt(j % input.length()) == 'b') b_cnt++;
            }
            min = Math.min(min, b_cnt);
        }

        System.out.println(min);
    }
}