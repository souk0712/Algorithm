import java.util.Scanner;

public class BOJ1316_그룹단어체커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] input = new String[N];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.next();
		}
		int ans = N;
		loop: for (int i = 0; i < N; i++) {
			boolean[] alpha = new boolean[26];
			for (int j = 0; j < input[i].length() - 1; j++) {
				char temp = input[i].charAt(j);
				if (alpha[temp % 'a']) {
					ans--;
					continue loop;
				}
				if (temp != input[i].charAt(j + 1))
					alpha[temp % 'a'] = true;
			}
			if (alpha[input[i].charAt(input[i].length() - 1) % 'a']) {
				ans--;
			}

		}
		System.out.println(ans);

	}

}
