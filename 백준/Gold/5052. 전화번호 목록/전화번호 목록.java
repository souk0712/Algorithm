import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        loop:
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] tel = new String[n];

            for (int i = 0; i < n; i++) {
                tel[i] = br.readLine();
            }

            Arrays.sort(tel);

            for (int i = 0; i < n - 1; i++) {
                String str = tel[i];
                int len = str.length();
                if (tel[i + 1].length() > len && tel[i + 1].substring(0, len).equals(str)) {
                    System.out.println("NO");
                    continue loop;
                }
            }

            System.out.println("YES");
        }
    }
}