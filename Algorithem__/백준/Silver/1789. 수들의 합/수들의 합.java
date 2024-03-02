import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        for (long i = 1; i <= N; i++) {
            sum += i;
            if (sum > N) {
                System.out.println(i - 1);
                return;
            } else if (sum == N) {
                System.out.println(i);
                return;
            }
        }
    }
}