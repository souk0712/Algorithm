import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            int count = 0;

            A = setBlank(A);
            B = setBlank(B);

            for (int i = 0; i < A.length(); i++) {
                char a = A.charAt(i);
                char b = B.charAt(i);
                for (int k = 0; k < 7; k++) {
                    String lightA = returnOutput(a);
                    String lightB = returnOutput(b);

                    if (lightA.charAt(k) != lightB.charAt(k)) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static String setBlank(String str) {
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < 5 - str.length(); i++) {
            tmp.append(" ");
        }
        tmp.append(str);

        return tmp.toString();
    }

    public static String returnOutput(char c) {
        String out = "";
        switch (c) {
            case '0':
                out = "1110111";
                break;
            case '1':
                out = "0010010";
                break;
            case '2':
                out = "1011101";
                break;
            case '3':
                out = "1011011";
                break;
            case '4':
                out = "0111010";
                break;
            case '5':
                out = "1101011";
                break;
            case '6':
                out = "1101111";
                break;
            case '7':
                out = "1110010";
                break;
            case '8':
                out = "1111111";
                break;
            case '9':
                out = "1111011";
                break;
            case ' ':
                out = "0000000";
                break;
        }

        return out;
    }
}