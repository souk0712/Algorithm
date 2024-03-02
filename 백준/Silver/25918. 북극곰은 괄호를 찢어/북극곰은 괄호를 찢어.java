import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (!stack.isEmpty()) {
                char s = stack.peek();
                if (c == '(' && s == ')') {
                    stack.pop();
                } else if (c == ')' && s == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
            count = Math.max(count, stack.size());
        }
        if (stack.isEmpty())
            System.out.println(count);
        else
            System.out.println(-1);
    }
}