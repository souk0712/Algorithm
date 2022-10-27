import java.util.Scanner;
import java.util.Stack;

public class BOj9012_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		loop: for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>();
			char[] input = sc.next().toCharArray();
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case '(':
					stack.push(input[i]);
					break;
				case ')':
					if (!stack.empty()) {
						stack.pop();
					} else {
						sb.append("NO\n");
						continue loop;
					}
					break;
				}
			}
			if (stack.empty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

}
