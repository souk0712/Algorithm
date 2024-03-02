import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {

	private static int L;
	private static int C;
	private static StringBuilder sb = new StringBuilder();
	private static String[] words;
	private static String[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		words = new String[L];

		input = new String[C];
		for (int i = 0; i < C; i++) {
			String tmp = st.nextToken();
			input[i] = tmp;
		}
		Arrays.sort(input);
		comb(0, 0, 0, 0);
		System.out.println(sb);
	}

	static void comb(int cnt, int start, int moeum, int jaeum) {
		if (moeum >= L - 1 || jaeum >= L)
			return;

		if (cnt == L) {
			for (int i = 0; i < words.length; i++) {
				sb.append(words[i]);
			}
			sb.append("\n");

			return;
		}
		for (int i = start; i < C; i++) {
			words[cnt] = input[i];
			if (input[i].equals("a") || input[i].equals("e") || input[i].equals("i") || input[i].equals("o")
					|| input[i].equals("u"))
				comb(cnt + 1, i + 1, moeum + 1, jaeum);
			else
				comb(cnt + 1, i + 1, moeum, jaeum + 1);
		}

	}

}
