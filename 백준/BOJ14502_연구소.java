import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502_연구소 {

	private static int[][] map;
	private static int N;
	private static int M;
	private static ArrayList<int[]> virus;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		virus = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		max = 0;
		makeWall(0);

		System.out.println(max);
	}

	private static void makeWall(int cnt) {
		if (cnt == 3) {
			virusBfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void virusBfs() {
		int[][] virusMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}

		while (!q.isEmpty()) {
			int[] v = q.poll();
			virusMap[v[0]][v[1]] = 2;
			for (int k = 0; k < 4; k++) {
				int x = v[0] + dx[k];
				int y = v[1] + dy[k];
				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				if (virusMap[x][y] == 0)
					q.add(new int[] { x, y });
			}
		}
		count(virusMap);
	}

	private static void count(int[][] virusMap) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 0) {
					count++;
				}
			}
		}
		if (count > max) {
			max = count;
		}
	}

}
