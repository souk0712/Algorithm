import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] minArr = new long[101];

        StringBuilder sb = new StringBuilder();
        Arrays.fill(minArr, Long.MAX_VALUE);
        minArr[2] = 1;
        minArr[3] = 7;
        minArr[4] = 4;
        minArr[5] = 2;
        minArr[6] = 6;
        minArr[7] = 8;
        minArr[8] = 10;

        String[] add = {"1", "7", "4", "2", "0", "8"};
        for (int i = 9; i < minArr.length; i++) {
            for (int j = 2; j <= 7; j++) {
                String s = "" + minArr[i - j] + add[j - 2];
                minArr[i] = Math.min(Long.parseLong(s), minArr[i]);
            }
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder max = new StringBuilder();
            // max
            if (N % 2 == 0) {
                int m = N / 2;
                for (int i = 0; i < m; i++) {
                    max.append(1);
                }
            } else {
                max.append(7);
                int m = N / 2;
                for (int i = 0; i < m - 1; i++) {
                    max.append(1);
                }
            }

            sb.append(minArr[N]).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}