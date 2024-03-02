import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        StringBuilder rev = sb.reverse();
        if (str.contentEquals(rev)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}