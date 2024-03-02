import java.util.Scanner;

public class SWEA1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, K;
		boolean[][] map;
		int count;
		int ans;
		for (int t = 1; t <= T; t++) {
			ans = 0;

			N = sc.nextInt();
			K = sc.nextInt();
			map = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					switch (sc.nextInt()) {
					case 1:
						map[i][j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						count = 1;
						j++;
						while (j < N && map[i][j]) {
							count++;
							j++;
						}
						if (count == K) {
							ans++;
						}
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j]) {
						count = 1;
						i++;
						while (i < N && map[i][j]) {
							count++;
							i++;
						}
						if (count == K) {
							ans++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

}
