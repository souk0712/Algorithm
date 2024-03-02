import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_키순서1_BFS {
	static int N, M;
	static int[][] map;
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
			for (int i = 1; i <= N; i++) {	// 모든 학생을 탐색의 시작점으로 하여 반복
				if (gtBFS(i) + ltBFS(i) == N - 1) {
					res++;
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}

	static int gtBFS(int start) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		int cnt = 0; // 나보다 큰 학생 수
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		v[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
				if (v[i]) { // 이미 방문한 좌표 무시
					continue;
				}
				if (map[cur][i] == 1) { // i가 cur보다 키가 크다
					cnt++; // 나보다 큰 애들 수 증가
					v[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}

	static int ltBFS(int start) { // start 학생부터 자신보다 키가 작은 학생따라 탐색
		int cnt = 0; // 나보다 작은 학생 수
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		v[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) {	// 인접행렬에서 자신의 열로 간선 정보를 갖고 있는 정점 들여다보기
				if (v[i]) { // 이미 방문한 좌표 무시
					continue;
				}
				if (map[i][cur] == 1) { // i가 cur보다 키가 작다
					cnt++; // 나보다 작은 애들 수 증가
					v[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}
}