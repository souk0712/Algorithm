import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		StringBuilder sb = new StringBuilder();
		String input = "";

		loop: while (true) {
			stack = new Stack<>();
			input = br.readLine();
			if (input.equals(".")) {
				break;
			}
			char[] temp = input.toCharArray();
			for (int i = 0; i < temp.length; i++) {
				switch (temp[i]) {
				case '(':
					stack.push(temp[i]);
					break;
				case '[':
					stack.push(temp[i]);
					break;
				case ')':
				case ']':
					if (stack.isEmpty()) {
						sb.append("no\n");
						continue loop;
					}
					char p = stack.pop();
					if (temp[i] == ')' && p == '(') {

					} else if (temp[i] == ']' && p == '[') {

					} else {
						sb.append("no\n");
						continue loop;
					}
					break;
				}
			}
			if (stack.isEmpty())
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.println(sb);
	}
}
