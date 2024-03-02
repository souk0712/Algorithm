import java.util.Scanner;

public class BOJ10971_외판원순회2 {
	static int min = 9_999_999;
	private static boolean[] visited;
	private static int N;
	private static int[][] cost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N];
		dfs(0, 0, 0);
		System.out.println(min);
	}

	private static void dfs(int cnt, int i, int sum) {
		if (cnt == N && i == 0) {
			min = Math.min(min, sum);
			return;
		}

		for (int j = 0; j < N; j++) {
			if (cost[i][j] == 0)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, j, sum + cost[i][j]);
				visited[i] = false;
			}
		}
	}
}
