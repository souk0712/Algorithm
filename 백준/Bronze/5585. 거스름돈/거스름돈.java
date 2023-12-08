import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] money = {500, 100, 50, 10, 5, 1};
    private static final int INIT = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int remain = INIT - N;
        int ans = 0;
        int index = 0;
        while (remain != 0) {
            if (remain >= money[index]) {
                ans += remain / money[index];
                remain %= money[index];
            } else {
                index++;
            }
        }
        System.out.println(ans);
    }
}