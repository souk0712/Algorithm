import java.util.Scanner;

public class Solution_키순서4_DFS_Memoization {
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
			for (int k = 1; k <= N; ++k) { // 경유
				for (int i = 1; i <= N; ++i) { // 출발
					if (i == k)
						continue;
					for (int j = 1; j <= N; ++j) { // 도착
						if (map[i][j] == 1)
							continue;
						map[i][j] = map[i][k] & map[k][j];
					}
				}
			}

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					map[i][0] += map[i][j]; // i보다 큰 j가 결국 카운트에 누적
					map[0][j] += map[i][j]; // j보다 작은 i가 결국 카운트에 누적
				}
			}

			for (int k = 1; k <= N; k++) {
				if (map[k][0] + map[0][k] == N - 1)
					res++;
			}

			System.out.println("#" + t + " " + res);
		}
	}

}