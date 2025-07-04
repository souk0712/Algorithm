import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int count = 1;
        int range = 2;

        while (range <= n) {
            range += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}