import java.util.Scanner;

public class BOJ1780_종이의개수 {

	private static int N;
	private static int[][] map;
	private static int first;
	private static int second;
	private static int third;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		first = 0;
		second = 0;
		third = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		divide(0, 0, N);
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
	}

	private static void divide(int x, int y, int size) {

		if (isSame(x, y, size)) {
			switch (map[x][y]) {
			case -1:
				first++;
				break;
			case 0:
				second++;
				break;
			case 1:
				third++;
				break;
			}
		} else {
			int nSize = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(x + nSize * i, y + nSize * j, nSize);
				}
			}
		}

	}

	private static boolean isSame(int startX, int startY, int size) {
		int A = map[startX][startY];
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (A != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
