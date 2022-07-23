package algo_1961;

import java.util.Scanner;

public class SWE_1961 {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int T = sc.nextInt();
		int[][] map;
		int[][] rotate_90;
		int[][] rotate_180;
		int[][] rotate_270;
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 처리
			rotate_90 = new int[N][N];
			rotate_180 = new int[N][N];
			rotate_270 = new int[N][N];

			rotateArray(rotate_90, map);
			rotateArray(rotate_180, rotate_90);
			rotateArray(rotate_270, rotate_180);

			// 출력
			System.out.println("#" + t);

			for (int i = 0; i < N; i++) {
				printArray(i, rotate_90);
				printArray(i,rotate_180);
				printArray(i,rotate_270);
				if (i != N - 1)
					sb.append("\n");
			}
			System.out.println(sb);

		}

	}

	private static void printArray(int i, int[][] arr) {
		for (int j = 0; j < N; j++) {
			sb.append(arr[i][j]);
		}
		sb.append(" ");
	}

	private static void rotateArray(int[][] arr, int[][] map) {
		int a = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[j][a] = map[i][j];
			}
			a--;
		}

	}

}
