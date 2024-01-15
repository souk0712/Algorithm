import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;
        while (B > A) {
            String b = Integer.toString(B);
            if (b.charAt(b.length() - 1) == '1') {
                B = Integer.parseInt(b.substring(0, b.length() - 1));
            } else if (B % 2 == 0) {
                B /= 2;
            }else {
                break;
            }
            count++;
        }
        if (A == B) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}