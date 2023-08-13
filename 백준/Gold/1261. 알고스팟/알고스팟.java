import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static private int[] dx = { -1, 1, 0, 0 };
	static private int[] dy = { 0, 0, -1, 1 };
	private static int M;
	private static int N;
	private static int[][] map;
	private static int min;
	private static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		min = 99999999;
		dijkstra(0, 0, 0);

		System.out.println(min);
	}

	private static void dijkstra(int i, int j, int cnt) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(i, j, cnt));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == N - 1 && p.y == M - 1) {
				min = Math.min(min, p.cnt);
				return;
			}

			for (int k = 0; k < dx.length; k++) {
				int x = p.x + dx[k];
				int y = p.y + dy[k];
				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;
				if (visited[x][y])
					continue;
				if (map[x][y] == 0) {
					queue.offer(new Point(x, y, p.cnt));
				}
				if (map[x][y] == 1) {
					queue.offer(new Point(x, y, p.cnt + 1));
				}
				visited[x][y] = true;

			}
		}

	}

	static class Point implements Comparable<Point> {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}

	}
}