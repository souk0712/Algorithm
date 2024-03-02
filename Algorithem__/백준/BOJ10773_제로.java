import java.util.Scanner;
import java.util.Stack;

public class BOJ10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int[] value = new int[K];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			if (a == 0) {
				stack.pop();
			} else {
				stack.push(a);
			}
		}
		int sum = 0;
		for (int a : stack) {
			sum += a;
		}
		System.out.println(sum);

	}

}
