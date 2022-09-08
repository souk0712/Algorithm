import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992_쿼드트리 {

	private static int N;
	private static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		quadTree(0, 0, N);
		System.out.println(sb);
	}

	public static void quadTree(int x, int y, int n) {
		int sum = 0;
		for (int i = x; i < n + x; i++) {
			for (int j = y; j < n + y; j++) {
				sum += map[i][j];
			}
		}

		if (sum == 0) {
			sb.append(0);
			return;
		}
		if (sum == n * n) {
			sb.append(1);
			return;
		}
		sb.append("(");
		quadTree(x, y, n / 2);
		quadTree(x, y + n / 2, n / 2);
		quadTree(x + n / 2, y, n / 2);
		quadTree(x + n / 2, y + n / 2, n / 2);
		sb.append(")");
	}

}
