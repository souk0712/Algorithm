import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int x, y, w, s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        long ans = 0;
        if (x == 0) {
            ans += getPlat(0, y);
        } else if (y == 0) {
            ans += getPlat(0, x);
        } else {
            if (x > y) {
                ans += getDiagonal(0, y);
                ans += getPlat(y, x);
            } else {
                ans += getDiagonal(0, x);
                ans += getPlat(x, y);
            }
        }
        System.out.println(ans);
    }

    private static long getDiagonal(int start, int end) {
        long diff = Math.abs(start - end);
        long ms = s * diff;
        long mw = w * diff * 2;
        return Math.min(mw, ms);
    }

    private static long getPlat(int start, int end) {
        long diff = Math.abs(start - end);
        long res;
        if (diff % 2 == 0) {
            res = Math.min(diff * s, diff * w);
        } else {
            res = Math.min((diff - 1) * s, (diff - 1) * w);
            res += w;
        }
        return res;
    }
}