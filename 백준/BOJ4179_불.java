import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ4179_불 {
	final static String IMPOS = "IMPOSSIBLE";
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int R;
	private static int C;
	private static char[][] map;
	private static int[][] time;
	private static Queue<Position> q;
	private static Position Jihun;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		time = new int[R][C];
		q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == 'F') {
					q.add(new Position(i, j));
					time[i][j] = 1;
				}
				if (map[i][j] == 'J') {
					Jihun = new Position(i, j);
				}
				if (map[i][j] == '#') {
					time[i][j] = -1;
				}
			}
		}
		fireBfs();
		int res = JBfs();
		if (res == -1)
			System.out.println(IMPOS);
		else
			System.out.println(res);

	}

	private static int JBfs() {
		Queue<Position> q = new LinkedList<>();
		int sec = 1;
		q.add(Jihun);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Position data = q.poll();

				for (int k = 0; k < dx.length; k++) {
					int x = data.x + dx[k];
					int y = data.y + dy[k];

					if (x < 0 || y < 0 || x >= R || y >= C)
						return sec;
					if (map[x][y] == '#' || map[x][y] == 'J')
						continue;
					if (time[x][y] > sec || time[x][y] == 0) {
						q.add(new Position(x, y));
						map[x][y] = 'J';
					}
				}
			}
			sec++;
		}
		return -1;

	}

	private static void fireBfs() {
		int sec = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Position data = q.poll();

				for (int k = 0; k < dx.length; k++) {
					int x = data.x + dx[k];
					int y = data.y + dy[k];
					if (x < 0 || y < 0 || x >= R || y >= C)
						continue;
					if (map[x][y] == '#' || time[x][y] != 0)
						continue;
					q.add(new Position(x, y));
					time[x][y] = sec;
				}
			}
			sec++;
		}
	}

	static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

	}
}
