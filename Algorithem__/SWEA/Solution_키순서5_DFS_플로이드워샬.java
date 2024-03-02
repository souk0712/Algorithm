import java.util.Scanner;

public class Solution_키순서5_DFS_플로이드워샬 {
	static int N, M;
	static int res;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int[][] map = new int[N + 1][N + 1]; // 1씩 더 크게 잡은 0첨자 버림, 자신보다 큰 학생 정보

			for (int i = 1; i <= N; i++) {
				map[i][0] = -1; // 탐색하지 않은 상태의 초기값
			}

			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 공간 복잡도를 올려서 소스를 단순화 한다.
				map[from][to] = 1; // a보다 b가 키가 크다, b보다 a가 키가 작다
			}
			res = 0;
			for (int i = 1; i <= N; i++) {
				if (map[i][0] == -1)
					dfs(i, map);
			}

			// 모든 정점이 알고있는 관계로 탐색을 마친 상태(큰 정점을 따라 탐색해서 간접관계를 직접관계로 다 반영해서 인접행렬 update)
			// 열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					map[0][k] += map[i][k];
				}
			}
			for (int k = 1; k <= N; k++) {
				if (map[k][0] + map[0][k] == N - 1)
					res++;
			}

			System.out.println("#" + t + " " + res);
		}
	}

	static void dfs(int cur, int[][] map) { // start 학생부터 자신보다 키가 크거나 작거나 학생따라 탐색

		for (int i = 1; i <= N; i++) {
			if (map[cur][i] == 1) {
				if (map[i][0] == -1)
					dfs(i, map); // 나보다 큰 i가 탐색을 하지 않은 상태면 탐색 go

				// 나보다 큰 정점의 탐색 정보를 메모
				if (map[i][0] > 0) { // i보다 큰 정점이 존재 : cur<i<j를 만족하는 j존재 ==> cur<j 상태로 메모
					for (int j = 1; j <= N; j++) {
						if (map[i][j] == 1)
							map[cur][j] = 1;
					}
				}
			}
		}
		// 자신보다 큰 정점의 탐색을 모두 완료 메모하기
        int cnt =0;
		for (int k = 1; k <= N; k++) {
			cnt += map[cur][k]; // 1의 개수만큼 더해짐!!
		}
		map[cur][0] = cnt;
	}
}