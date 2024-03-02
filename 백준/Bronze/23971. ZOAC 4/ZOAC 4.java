import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        H = Double.parseDouble(st.nextToken());
        W = Double.parseDouble(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        double h = Math.ceil(H / (N + 1));
        double w = Math.ceil(W / (M + 1));
        
        System.out.println((int) (h * w));
    }
}
