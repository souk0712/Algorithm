import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Character> charList = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+') {
                intList.add(Integer.parseInt(temp.toString()));
                temp = new StringBuilder();
                charList.add(c);
            } else {
                temp.append(c);
            }
        }
        intList.add(Integer.parseInt(temp.toString()));

        int sum = 0;
        boolean check = false;
        if (intList.size() == charList.size()) {
            for (int i = 0; i < intList.size(); i++) {
                int ii = intList.get(i);
                char c = charList.get(i);

                if (c == '-') {
                    check = true;
                }

                if (check) {
                    sum -= ii;
                } else {
                    sum += ii;
                }
            }
        } else {
            sum = intList.get(0);

            for (int i = 1; i < intList.size(); i++) {
                int ii = intList.get(i);
                char c = charList.get(i - 1);

                if (c == '-') {
                    check = true;
                }

                if (check) {
                    sum -= ii;
                } else {
                    sum += ii;
                }
            }
        }

        System.out.println(sum);
    }
}