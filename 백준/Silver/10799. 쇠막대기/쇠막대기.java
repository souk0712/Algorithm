import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add(chars[i]);
            } else if (chars[i] == ')') {
                stack.pop();
                if (chars[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}