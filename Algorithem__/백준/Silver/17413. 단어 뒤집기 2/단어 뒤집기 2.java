import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder(input);
        StringBuilder tmp = new StringBuilder();
        StringBuilder print = new StringBuilder();

        boolean check = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            switch (c) {
                case '<':
                    check = true;
                case ' ':
                    print.append(tmp);
                    tmp = new StringBuilder();
                    print.append(c);
                    break;

                case '>':
                    check = false;
                    print.append(c);
                    break;

                default:
                    if (check) {
                        print.append(c);
                    } else {
                        tmp.insert(0, c);
                    }
                    break;
            }
        }

        if (tmp.length() != 0) {
            print.append(tmp);
        }

        System.out.println(print);
    }
}