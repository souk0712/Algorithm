import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[2 * N];
            boolean[] visit = new boolean[2 * N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (visit[i]) continue;
                double discount = arr[i] * 0.75;
                for (int j = i - 1; j >= 0; j--) {
                    if (visit[j]) continue;
                    if (arr[j] == discount) {
                        visit[j] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}