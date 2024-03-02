import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] alpha = new int[26];
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            if (K == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (alpha[c - 'a'] < K) continue;

                int count = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    char cc = str.charAt(j);
                    if (c == cc) count++;
                    if (count == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb);
    }
}