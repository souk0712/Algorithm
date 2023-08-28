import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int num = N / 5;
        int mod = N % 5;

        while (num >= 0 && mod > 0) {
            int n = mod / 3;
            int m = mod % 3;

            if (m == 0) {
                num += n;
                mod = 0;
            } else {
                num--;
                mod += 5;
            }
        }

        System.out.println(mod > 0 ? -1 : num);
    }
}