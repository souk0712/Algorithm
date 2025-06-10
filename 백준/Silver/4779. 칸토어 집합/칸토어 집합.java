import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] lineArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb = new StringBuilder();
            int len = (int) Math.pow(3, N);
            lineArr = new char[len];
            Arrays.fill(lineArr, '-');

            divString(0, len);

            for (int i = 0; i < lineArr.length; i++) {
                sb.append(lineArr[i]);
            }
            System.out.println(sb);
        }
    }

    private static void divString(int start, int length) {
        if (length <= 1) {
            return;
        }
        int newLength = length / 3;
        for (int i = start + newLength; i < start + newLength * 2; i++) {
            lineArr[i] = ' ';
        }
        divString(start, newLength);
        divString(start + newLength * 2, newLength);
    }
}