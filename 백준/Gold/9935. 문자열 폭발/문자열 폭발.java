import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (stack.size() >= bomb.length()) {
                boolean check = true;

                for (int j = 0; j < bomb.length(); j++) {

                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
                    }
                }

                if (check) {
                    for (int k = 0; k < bomb.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}