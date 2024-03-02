import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        Arrays.sort(N);
        StringBuilder str = new StringBuilder();
        int sum = 0;

        boolean check = false;
        for (int i = N.length - 1; i >= 0; i--) {
            sum += (N[i] - '0');
            str.append(N[i]);
            if (N[i] == '0') check = true;
        }
        if (check && sum % 3 == 0) {
            System.out.println(str);
        } else {
            System.out.println(-1);
        }
    }
}