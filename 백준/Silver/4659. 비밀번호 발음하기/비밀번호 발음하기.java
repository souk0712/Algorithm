import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
    모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
    모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Boolean> word = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                word.put(c, true);
            } else {
                word.put(c, false);
            }
        }

        while (true) {
            String input = br.readLine();
            if ("end".equals(input)) {
                break;
            }

            boolean first = true;
            boolean check = true;
            int countM = 0;
            int countJ = 0;
            char com = ' ';
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                // 모음
                if (word.get(c)) {
                    countM++;
                    countJ = 0;
                    first = false;
                } else {    // 자음
                    countJ++;
                    countM = 0;
                }

                if (c != 'e' && c != 'o') {
                    if (com == c) {
                        check = false;
                        break;
                    }
                }

                if (countJ == 3 || countM == 3) {
                    check = false;
                    break;
                }

                com = c;
            }

            if (first) check = false;

            sb.append("<").append(input).append(">");
            if (!check) {
                sb.append(" is not acceptable.\n");
            } else {
                sb.append(" is acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}