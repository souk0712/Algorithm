import java.util.Scanner;

public class SWEA1974_스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 9;
		int T = sc.nextInt();
		int[][] sdoku = new int[N][N];
		boolean[] check;
		int ans;
		for (int t = 1; t <= T; t++) {
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}
			loop: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// 3*3탐색
					check = new boolean[N];
					for (int l = i * 3; l < (i + 1) * 3; l++) {
						for (int k = j * 3; k < (j + 1) * 3; k++) {
							if (check[sdoku[l][k] - 1]) {
								ans = 0;
								break loop;
							}
							check[sdoku[l][k] - 1] = true;
						}
					}

					// 가로 한 줄 탐색
					for (int l = i * 3; l < (i + 1) * 3; l++) {
						check = new boolean[N];
						for (int k = 0; k < N; k++) {
							if (check[sdoku[l][k] - 1]) {
								ans = 0;
								break loop;
							}
							check[sdoku[l][k] - 1] = true;
						}
					}
					// 세로 한 줄 탐색
					for (int l = j * 3; l < (j + 1) * 3; l++) {
						check = new boolean[N];
						for (int k = 0; k < N; k++) {
							if (check[sdoku[k][l] - 1]) {
								ans = 0;
								break loop;
							}
							check[sdoku[k][l] - 1] = true;
						}
						ans = 1;
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}

	}

}
