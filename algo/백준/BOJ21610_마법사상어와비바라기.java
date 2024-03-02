import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ21610_마법사상어와비바라기 {

	private static int[][] map;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int[][] move;
	static List<int[]> cloud;
	private static int N;
	private static int M;
	private static boolean[][] cloudArea;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];

		cloud = new ArrayList<>();
		move = new int[M][2];

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < move.length; i++) {
			move[i][0] = sc.nextInt();
			move[i][1] = sc.nextInt();
		}

		for (int i = N - 2; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				cloud.add(new int[] { i, j });
			}
		}

		createRainCloud();

		for (int[] i : map) {
			for (int j : i) {
				ans += j;
			}
		}
		System.out.println(ans);

	}

	private static void createRainCloud() {
		for (int m = 0; m < M; m++) {
			cloudArea = new boolean[N][N];
			int d = move[m][0];
			int s = move[m][1];
			for (int j = 0; j < cloud.size(); j++) {
				cloud.get(j)[0] = (cloud.get(j)[0] + (dx[d - 1] * (s % N)) + N) % N;
				cloud.get(j)[1] = (cloud.get(j)[1] + (dy[d - 1] * (s % N)) + N) % N;

				map[cloud.get(j)[0]][cloud.get(j)[1]] += 1;

			}
			for (int j = 0; j < cloud.size(); j++) {
				int count = 0;
				int r = cloud.get(j)[0];
				int c = cloud.get(j)[1];
				for (int i = 1; i <= 4; i++) {
					int x = r + dx[2 * i - 1];
					int y = c + dy[2 * i - 1];
					if (x < 0 || x >= N || y < 0 || y >= N)
						continue;
					if (map[x][y] != 0)
						count++;

				}
				map[r][c] += count;
			}
			for (int i = 0; i < cloud.size(); i++) {
				cloudArea[cloud.get(i)[0]][cloud.get(i)[1]] = true;
			}

			cloud.removeAll(cloud);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !cloudArea[i][j]) {
						cloud.add(new int[] { i, j });
						map[i][j] -= 2;
					}
				}
			}
		}
	}

}
