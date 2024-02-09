import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] unit = {25, 10, 5, 1};
        for (int t = 0; t < T; t++) {
            int money = Integer.parseInt(br.readLine());
            int[] answer = new int[4];
            for (int i = 0; i < unit.length; i++) {
                int n = money / unit[i];
                int m = money % unit[i];
                answer[i] = n;
                money = m;
                if (money <= 0) break;
            }
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}