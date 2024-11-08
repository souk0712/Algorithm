import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] A = new int[h][w];
        int[][] B = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                A[i][j] -= A[i - x][j - y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}