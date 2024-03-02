import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637_괄호추가하기 {

	private static int N;
	private static char[] input;
	private static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 홀수
		// +, -, *
		input = br.readLine().toCharArray();
		max = Integer.MIN_VALUE;

		dfs(2, input[0] - '0');
		System.out.println(max);
	}

	private static void dfs(int i, int sum) {
		if (i >= N) {
			max = Math.max(max, sum);
			return;
		}

		dfs(i + 2, calc(sum, input[i] - '0', input[i - 1]));
		if (i + 2 < N) {
			dfs(i + 4, calc(sum, calc(input[i] - '0', input[i + 2] - '0', input[i + 1]), input[i - 1]));
		}
	}

	private static int calc(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 0;
	}

}
