import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178_미로탐색 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = tmp[j - 1] - '0';
			}
		}

		int res = 1;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(1, 1));
		map[1][1]++;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == N && p.y == M) {
					System.out.println(res);
					return;
				}

				for (int k = 0; k < 4; k++) {
					int x = p.x + dx[k];
					int y = p.y + dy[k];
					if (x <= 0 || y <= 0 || x > N || y > M)
						continue;
					if (map[x][y] == 0 || map[x][y] > 1)
						continue;
					q.add(new Point(x, y));
					map[x][y]++;
				}
			}
			res++;
		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

}
