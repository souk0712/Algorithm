import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        loop:
        while (true) {
            String input = br.readLine();
            if (".".equals(input)) break;
            else {
                Stack<Character> stack = new Stack<>();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    switch (c) {
                        case '(':
                        case '[':
                            stack.push(c);
                            break;

                        case ')':
                        case ']':
                            if (!stack.isEmpty()) {
                                char cc = stack.pop();
                                if (c == ')' && cc != '(') {
                                    sb.append("no").append("\n");
                                    continue loop;
                                } else if (c == ']' && cc != '[') {
                                    sb.append("no").append("\n");
                                    continue loop;
                                }
                            } else {
                                sb.append("no").append("\n");
                                continue loop;
                            }
                            break;
                    }
                }
                if (stack.isEmpty())
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}