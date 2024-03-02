import java.util.Scanner;

public class BOJ15685_드래곤커브 {
	// 0: x좌표가 증가하는 방향 (→)
	// 1: y좌표가 감소하는 방향 (↑)
	// 2: x좌표가 감소하는 방향 (←)
	// 3: y좌표가 증가하는 방향 (↓)
	static private int[] dx = { 1, 0, -1, 0 }; // 우, 상, 좌, 하
	static private int[] dy = { 0, -1, 0, 1 };
	private static int N;
	private static int[][] input;
	private static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N][4];
		check = new boolean[101][101];
		int ans = 0;
		// 시작 x, 시작 y, 시작 방향, 세대
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			dragonCurve(i);
		}

		// 크기가 1인 정사각형을 이루면 ans++
		for (int i = 0; i < check.length - 1; i++) {
			for (int j = 0; j < check[i].length - 1; j++) {
				if (check[i][j] && check[i + 1][j] && check[i][j + 1] && check[i + 1][j + 1]) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

	private static void dragonCurve(int i) {
		int d = input[i][2];
		int end = input[i][3];
		int length = (int) Math.pow(2, end);
		int[] curves = new int[length]; // 세대에 맞는 방향
		curves[0] = d;

		// 세대 반복
		for (int j = 1; j <= end; j++) {
			int pow = (int) Math.pow(2, j);
			for (int k = 0, l = pow - 1; k < pow / 2; k++) {
				curves[l--] = (curves[k] + 1) % 4;
			}
		}
		int ri = input[i][0];
		int rj = input[i][1];
		// 첫 시작점
		check[rj][ri] = true;

		// 시작 점에서 방향따라 이동하고, 방문체크
		for (int j = 0; j < curves.length; j++) {
			ri += dx[curves[j]];
			rj += dy[curves[j]];
			check[rj][ri] = true;
		}
	}
}
