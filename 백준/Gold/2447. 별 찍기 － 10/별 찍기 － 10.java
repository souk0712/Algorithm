import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pickStar(i, j, N);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void pickStar(int x, int y, int size) {

        if ((x / size) % 3 == 1 && (y / size) % 3 == 1) {
            sb.append(" ");
        } else {
            if (size / 3 == 0)
                sb.append("*");
            else
                pickStar(x, y, size / 3);
        }
    }
}