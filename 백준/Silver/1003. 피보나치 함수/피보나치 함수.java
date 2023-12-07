import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[] zero, one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        zero = new int[41];
        one = new int[41];
        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;
        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zero[N]).append(" ").append(one[N]).append("\n");
        }
        System.out.println(sb);
    }
}