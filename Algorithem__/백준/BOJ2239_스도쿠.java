import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239_스도쿠 {

	private static int[][] map;
	private static boolean isEnd = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s[j] - '0';

			}
		}
		fillSdoku(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void fillSdoku(int depth) {
		if (depth == 81) {
			isEnd = true;
			return;
		}
		int x = depth / 9;
		int y = depth % 9;
		if (map[x][y] != 0) {
			fillSdoku(depth + 1);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (isPossible(x, y, i)) {
				map[x][y] = i;
				fillSdoku(depth + 1);
				if (isEnd)
					return;
				map[x][y] = 0;
			}
		}

	}

	private static boolean isPossible(int x, int y, int i) {
		// 가로, 세로
		for (int j = 0; j < 9; j++) {
			if (map[x][j] == i || map[j][y] == i) {
				return false;
			}
		}

		// 9칸
		int sx = x / 3 * 3; // 방법 1
		int sy = y - y % 3; // 방법 2

		for (int j = sx; j < sx + 3; j++) {
			for (int k = sy; k < sy + 3; k++) {
				if (map[j][k] == i) {
					return false;
				}
			}
		}

		return true;
	}
}
