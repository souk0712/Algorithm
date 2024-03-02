import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, r, c, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        count = 0;
        int n = (int) Math.pow(2, N);

        fillMap(0, 0, n);

        System.out.println(count);
    }

    private static void fillMap(int x, int y, int size) {
        if (size == 2) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (i == r && j == c) {
                        return;
                    }
                    count++;
                }
            }
            return;
        }

        int nSize = size / 2;

        if (r - x < nSize && c - y < nSize)                      // 1사분면
            fillMap(x, y, nSize);

        else if (r - x < nSize && c - y >= nSize) {              // 2사분면
            fillMap(x, y + nSize, nSize);
            count += nSize * nSize;

        } else if (r - x >= nSize && c - y < nSize) {           // 3사분면
            fillMap(x + nSize, y, nSize);
            count += 2 * nSize * nSize;

        } else if (r - x >= nSize && c - y >= nSize) {          // 4사분면
            fillMap(x + nSize, y + nSize, nSize);
            count += 3 * nSize * nSize;

        }
    }
}