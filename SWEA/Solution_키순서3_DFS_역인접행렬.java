import java.util.Scanner;

public class Solution_키순서3_DFS_역인접행렬 {
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
			int[][] rmap = new int[N + 1][N + 1]; // 1씩 더 크게 잡은 0첨자 버림 , 자신보다 작은 학생 정보
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 공간 복잡도를 올려서 소스를 단순화 한다.
				rmap[to][from] = map[from][to] = 1; // a보다 b가 키가 크다, b보다 a가 키가 작다
			}
			res = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				dfs(i, map, new boolean[N + 1]);
				dfs(i, rmap, new boolean[N + 1]);
				if (cnt == N - 1) {
					res++;
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}

	static void dfs(int cur, int[][] map, boolean[] v) { // start 학생부터 자신보다 키가 크거나 작거나 학생따라 탐색
		v[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (v[i]) { // 이미 방문한 좌표 무시
				continue;
			}
			if (map[cur][i] == 1) { // map 전달 대상에 따라 i가 cur보다 키가 큰 경우(i가 cur보다 키가 작은 경우) 아직 탐색되지 않았다면
				cnt++; // map 전달 대상에 따라 나보다 크거나 작은 애들 수 증가
				dfs(i, map, v);
			}
		}
	}
}