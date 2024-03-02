import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] basket = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken());
            int jj = Integer.parseInt(st.nextToken());
            int kk = Integer.parseInt(st.nextToken());
            for (int j = ii; j <= jj; j++) {
                basket[j] = kk;
            }
        }
        for (int i = 1; i < basket.length; i++) {
            sb.append(basket[i]).append(" ");
        }
        System.out.println(sb);
    }
}