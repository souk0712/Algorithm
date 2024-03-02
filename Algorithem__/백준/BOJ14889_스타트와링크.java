import java.util.Scanner;

public class BOJ14889_스타트와링크 {

	private static int N;
	private static int[][] map;
	private static int ans;
	private static int[] startTeam;
	private static int[] linkTeam;
	private static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		startTeam = new int[N / 2];
		linkTeam = new int[N / 2];
		check = new boolean[N];
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			int sumS = 0;
			int sumL = 0;
			for (int i = 0, index = 0; i < N; i++) {
				if (!check[i])
					linkTeam[index++] = i;
			}
			for (int i = 0; i < startTeam.length; i++) {
				for (int j = 0; j < startTeam.length; j++) {
					if (i == j)
						continue;
					sumS += map[startTeam[i]][startTeam[j]];
				}
			}
			for (int i = 0; i < linkTeam.length; i++) {
				for (int j = 0; j < linkTeam.length; j++) {
					if (i == j)
						continue;
					sumL += map[linkTeam[i]][linkTeam[j]];
				}
			}

			if (ans > Math.abs(sumL - sumS)) {
				ans = Math.abs(sumL - sumS);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			startTeam[cnt] = i;
			check[i] = true;
			comb(cnt + 1, i + 1);
			check[i] = false;
		}
	}
}
