import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_알파벳 {

	private static int R;
	private static int C;
	private static char[][] board;
	private static int max = 0;
	private static boolean[] check;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		check = new boolean[26];
		maxBlank(0, 0, 0);
		System.out.println(max);
	}

	private static void maxBlank(int i, int j, int count) {
		int index = board[i][j] % 'A';
		if (check[index]) {
			if (count > max) {
				max = count;
			}
			return;
		}
		count++;
		check[index] = true;

		for (int k = 0; k < dx.length; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= R || y < 0 || y >= C)
				continue;
			boolean tmp = check[board[x][y] % 'A'];
			maxBlank(x, y, count);
			check[board[x][y] % 'A'] = tmp;
		}
	}

}
