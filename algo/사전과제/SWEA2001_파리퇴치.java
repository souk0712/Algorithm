import java.util.Scanner;

public class SWEA2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, M;
		int[][] map;
		int[][] flat;
		int sum, max;
		for (int t = 1; t <= T; t++) {
			// 입력
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			flat = new int[M][M];
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 처리
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					// 파리채
					sum = 0;
					for (int l = i; l < M + i; l++) {
						for (int k = j; k < M + j; k++) {
							sum += map[l][k];
						}
					}
					if (sum > max)
						max = sum;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

}
