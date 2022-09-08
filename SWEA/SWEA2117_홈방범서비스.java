import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA2117_홈방범서비스 {
	private static int N;
	private static int M;
	private static int[][] map;
	private static int ans;
	private static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int K = 1;
			int result = 99999;
			int cost = K * K + (K - 1) * (K - 1);
			while (result >= cost) {
				K++;
				result = bfs(0, 0, K);
			}
			System.out.println("#" + t + " ");
		}
	}

	static int bfs(int i, int j, int k) {
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { i, j });

		while (!q.isEmpty()) {

		}
		return k;

	}

}
