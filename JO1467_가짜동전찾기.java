import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1467_가짜동전찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long weight = Long.parseLong(br.readLine());
		long ans = -1;

		double value = (double) (weight - N * (N + 1) / 2 * A) / (double) (B - A);
		if (A != B && value > 0) {
			if (value == (long) value) {
				ans = (long) value;
			}
		}

		System.out.println(ans);

	}

}