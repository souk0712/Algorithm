import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_키순서2_DFS {
	static int N, M;
	static int[][] map;
	static int gtCnt, ltCnt;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N + 1][N + 1]; // 1씩 더 크게 잡은 0첨자 버림
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1; // a보다 b가 키가 크다
			}
			res = 0;
			for (int i = 1; i <= N; i++) { // 모든 학생을 탐색의 시작점으로 하여 반복
				gtCnt = ltCnt = 0; // 초기화

				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);

				if (gtCnt + ltCnt == N - 1) {
					res++;
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}

	static void gtDFS(int cur, boolean[] visited) { // cur 학생부터 자신보다 키가 큰 학생따라 탐색
		visited[cur] = true;

		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
			if (visited[i]) { // 이미 방문한 좌표 무시
				continue;
			}
			if (map[cur][i] == 1) { // i가 cur보다 키가 크다
				gtCnt++; // 나보다 큰 애들 수 증가
				gtDFS(i, visited);
			}
		}
	}

	static void ltDFS(int cur, boolean[] visited) { // cur 학생부터 자신보다 키가 작은 학생따라 탐색
		visited[cur] = true;

		for (int i = 1; i <= N; i++) { // 인접행렬에서 자신의 열로 간선 정보를 갖고 있는 정점 들여다보기
			if (visited[i]) { // 이미 방문한 좌표 무시
				continue;
			}
			if (map[i][cur] == 1) { // i가 cur보다 키가 작다
				ltCnt++; // 나보다 작은 애들 수 증가
				ltDFS(i, visited);
			}
		}
	}
}