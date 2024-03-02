import java.math.BigInteger;
import java.util.*;

public class 숫자짝꿍 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "123450";
        String res = solution(X, Y);
        System.out.println(res);
    }

    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();

        int[] visitX = new int[10];
        int[] visitY = new int[10];

        for (int i = 0; i < x.length; i++) {
            visitX[x[i] - '0']++;
        }
        for (int i = 0; i < y.length; i++) {
            visitY[y[i] - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            for (int a = 0; a < Math.min(visitX[i], visitY[i]); a++)
                sb.append(i);
        }
        if (sb.length() == 0) {
            return "-1";
        }
        if(sb.charAt(0)=='0')
            return "0";
        return sb.toString();
    }
}
