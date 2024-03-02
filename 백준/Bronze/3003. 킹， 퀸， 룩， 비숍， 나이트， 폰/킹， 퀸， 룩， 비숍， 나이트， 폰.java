import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] right = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            sb.append(right[i] - a).append(" ");
        }
        System.out.println(sb);
    }
}